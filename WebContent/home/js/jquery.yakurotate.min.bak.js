;
(function($) {
	$.yakurotate = function(el, options) {
		var s = this;
		s.el = el;
		s.$el = $(el);
		s.$el.data('yakurotate', s);
		s.animated = false;
		s.timer = false;
		s.init = function() {
			s.opts = $.extend( {}, $.yakurotate.defaults, options);
			s.$items = s.$el.children();
			s.itemLength = s.$items.length;
			s.width = s.$items.eq(0).width();
			s.height = s.$items.eq(0).height();
			s.currentIndex = 1;
			s.wrapBox();
			s.cloneAdd();
			s.setPosition();
			s.setEventBind();
			if (s.opts.showNav) {
				s.setNav()
			}
			if (s.opts.autoStart) {
				s.play()
			}
		};
		s.wrapBox = function() {
			s.$container = $("<div class='roate-container'></div>");
			s.$wrap = $("<div class='roate-wrap'></div>").css( {
				'overflow' : 'hidden',
				'position' : 'relative',
				'width' : s.width,
				'height' : s.height
			});
			s.$container.append(s.$wrap);
			s.$el.wrap(s.$container);
			s.$el.css( {
				'position' : 'absolute'
			});
			if (s.opts.move === 'h') {
				s.$items.css('float', 'left')
			}
		};
		s.setNav = function() {
			var box = "", selectedClass = "";
			for ( var i = 0, cnt = s.itemLength; i < cnt; i++) {
				selectedClass = (i === 0) ? "roate-num-selected" : "";
				box += "<a href='#' class='" + selectedClass + " roate-num'>"
						+ (i + 1) + "</a>"
			}
			if (s.opts.navContainer) {
				$(s.opts.navContainer).append(box);
				s.$nav = $(s.opts.navContainer)
			} else {
				s.$nav = $("<div class='roate-nav'>" + box + "</div>");
				s.$el.parent().parent().append(s.$nav)
			}
			s.$nav.find(".roate-num").on("click.roate", function() {
				s.stop();
				s.transition('next', $(this).index() + 1);
				if (s.opts.autoStart) {
					s.play()
				}
			})
		};
		s.cloneAdd = function() {
			s.$el.children('.cloned').remove();
			s.$el.prepend(s.$items.filter(':last').clone().addClass('cloned'));
			s.$el.append(s.$items.filter(':first').clone().addClass('cloned'));
			s.$el.find('.cloned').each(function() {
				$(this).find('a,input,textarea,select,button,area,form').attr( {
					disabled : 'disabled',
					name : ''
				});
				$(this).find('[id]').andSelf().removeAttr('id')
			})
		};
		s.setPosition = function() {
			var tot = 0;
			s.$el.children().each(
					function() {
						tot += (s.opts.move === 'v') ? $(this).height() : $(
								this).width()
					});
			if (s.opts.move === 'h') {
				s.$el.css( {
					'width' : tot + 'px',
					'left' : '-' + s.width + 'px'
				})
			} else {
				s.$el.css( {
					'heihgt' : tot + 'px',
					'top' : '-' + s.height + 'px'
				})
			}
			s.$items.eq(0).addClass(s.opts.activeClass)
		};
		s.displayPlayButton = function() {
			$(s.opts.playButton).css('display', 'inline');
			$(s.opts.stopButton).css('display', 'none')
		};
		s.displayStopButton = function() {
			$(s.opts.playButton).css('display', 'none');
			$(s.opts.stopButton).css('display', 'inline')
		};
		s.setelectNav = function(index) {
			if (s.opts.showNav) {
				s.$nav.find(".roate-num").removeClass("roate-num-selected").eq(
						(index || s.currentIndex) - 1).addClass(
						"roate-num-selected")
			}
		};
		s.active = function(index) {
			s.$items.removeClass(s.opts.activeClass).eq(s.currentIndex - 1)
					.addClass(s.opts.activeClass)
		};
		s.setDirection = function(direction, index) {
			if (index) {
				s.currentIndex = index
			} else {
				(direction === 'next') ? s.currentIndex++ : s.currentIndex--
			}
		};
		s.transition = function(direction, index) {
			s.setDirection(direction, index);
			var moving = {};
			if (s.opts.move === 'h') {
				moving['left'] = '-' + ((index || s.currentIndex) * s.width) + 'px'
			} else {
				moving['top'] = '-' + ((index || s.currentIndex) * s.height) + 'px'
			}
			if (s.opts.fade) {
				s.$el.css('opacity', 0);
				moving['opacity'] = 1
			}
			if (s.animated === false) {
				s.animated = true;
				s.$el.filter(':not(:animated)').animate(moving, {
					queue : false,
					duration : s.opts.duration,
					complete : function() {
						s.endAnimate(index)
					}
				})
			}
		};
		s.endAnimate = function(index) {
			if (s.currentIndex <= 0) {
				s.currentIndex = s.itemLength;
				if (s.opts.move === 'v') {
					s.$el.css('top', '-' + (s.currentIndex * s.height) + 'px')
				} else {
					s.$el.css('left', '-' + (s.currentIndex * s.width) + 'px')
				}
			} else if (s.currentIndex > s.itemLength) {
				s.currentIndex = 1;
				if (s.opts.move === 'v') {
					s.$el.css('top', '-' + s.height + 'px')
				} else {
					s.$el.css('left', '-' + s.width + 'px')
				}
			}
			s.active();
			s.setelectNav(index);
			s.animated = false
		};
		s.play = function() {
			s.displayStopButton();
			if (s.timer) {
				clearInterval(s.timer)
			}
			s.timer = setInterval(function() {
				s.transition('next')
			}, s.opts.interval)
		};
		s.stop = function() {
			if (s.timer) {
				clearInterval(s.timer);
				s.timer = false;
				s.displayPlayButton()
			}
		};
		s.setEventBind = function() {
			$(s.opts.nextButton).off('click.roate');
			$(s.opts.prevButton).off('click.roate');
			$(s.opts.playButton).off('click.roate');
			$(s.opts.stopButton).off('click.roate');
			$(s.opts.nextButton).on('click.roate', function() {
				s.stop();
				s.transition('next');
				if (s.opts.autoStart) {
					s.play()
				}
			});
			$(s.opts.prevButton).on('click.roate', function() {
				s.stop();
				s.transition('prev');
				if (s.opts.autoStart) {
					s.play()
				}
			});
			$(s.opts.playButton).on('click.roate', function() {
				s.stop();
				s.play()
			});
			$(s.opts.stopButton).on('click.roate', function() {
				s.stop()
			});
			s.$el.hover(function() {
				s.stop()
			}, function() {
				s.play()
			})
		};
		s.init()
	};
	$.yakurotate.defaults = {
		'theme' : 'default',
		'duration' : 1000,
		'interval' : 2000,
		'stopButton' : '#stopButton',
		'playButton' : '#playButton',
		'prevButton' : '#prevButton',
		'nextButton' : '#nextButton',
		'move' : 'top',
		'fade' : false,
		'autoStart' : true,
		'activeClass' : 'active',
		'navContainer' : false,
		'showNav' : true
	};
	$.fn.yakurotate = function(options) {
		return this.each(function() {
			var $this = $(this), rotate = $this.data('yakurotate');
			if (!rotate) {
				rotate = new $.yakurotate(this, options)
			}
			if (typeof options === 'number') {
				rotate.transition('next', options)
			} else if (typeof (options) === 'string') {
				if ($.isFunction(rotate[options])) {
					rotate[options]()
				}
			}
		})
	}
})(jQuery);