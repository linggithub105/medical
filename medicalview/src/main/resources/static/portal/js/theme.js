(function($) {
    "use strict";

    if ($('.wow').length) {
        var wow = new WOW({
            boxClass: 'wow', // animated element css class (default is wow)
            animateClass: 'animated', // animation css class (default is animated)
            offset: 250, // distance to the element when triggering the animation (default is 0)
            mobile: true, // trigger animations on mobile devices (default is true)
            live: true // act on asynchronously loaded content (default is true)
        });
        wow.init();
    }

    if ($('.accrodion-grp').length) {
        var accrodionGrp = $('.accrodion-grp');
        accrodionGrp.each(function() {
            var accrodionName = $(this).data('grp-name');
            var Self = $(this);
            var accordion = Self.find('.accrodion');
            Self.addClass(accrodionName);
            Self.find('.accrodion .accrodion-content').hide();
            Self.find('.accrodion.active').find('.accrodion-content').show();
            accordion.each(function() {
                $(this).find('.accrodion-title').on('click', function() {
                    if ($(this).parent().hasClass('active') === false) {
                        $('.accrodion-grp.' + accrodionName).find('.accrodion').removeClass('active');
                        $('.accrodion-grp.' + accrodionName).find('.accrodion').find('.accrodion-content').slideUp();
                        $(this).parent().addClass('active');
                        $(this).parent().find('.accrodion-content').slideDown();
                    };


                });
            });
        });

    };

    if ($('.quantity-spinner').length) {
        $("input.quantity-spinner").TouchSpin({

        });
    }

    if ($('.product-details__thumb-carousel').length) {
        var productDetailsThumbCarousel = new Swiper('.product-details__thumb-carousel', {
            slidesPerView: 5,
            spaceBetween: 10,
            freeMode: true,
            speed: 1400,
            watchSlidesVisibility: true,
            watchSlidesProgress: true,
            loop: true,
            autoplay: {
                delay: 5000,
            },
        });
    }


    if ($('.product-details__carousel').length) {
        var productDetailsCarousel = new Swiper('.product-details__carousel', {
            observer: true,
            observeParents: true,
            speed: 1400,
            mousewheel: true,
            autoplay: {
                delay: 5000,
            },
            thumbs: {
                swiper: productDetailsThumbCarousel
            }
        });
    }

    if ($('.main-navigation .navigation-box .submenu').length) {
        var subMenu = $('.main-navigation .submenu');
        subMenu.parent('li').children('a').append(function() {
            return '<button class="sub-nav-toggler"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>';
        });
        var mainNavToggler = $('.header-navigation .menu-toggler');
        var subNavToggler = $('.main-navigation .sub-nav-toggler');
        mainNavToggler.on('click', function() {
            var Self = $(this);
            var menu = Self.closest('.header-navigation').find(Self.data('target'));
            $(menu).slideToggle();
            $(menu).toggleClass('showen');
            return false;
        });
        subNavToggler.on('click', function() {
            var Self = $(this);
            Self.parent().parent().children('.submenu').slideToggle();
            return false;
        });
    }

    if ($('.img-popup').length) {
        var groups = {};
        $('.img-popup').each(function() {
            var id = parseInt($(this).attr('data-group'), 10);

            if (!groups[id]) {
                groups[id] = [];
            }

            groups[id].push(this);
        });


        $.each(groups, function() {

            $(this).magnificPopup({
                type: 'image',
                closeOnContentClick: true,
                closeBtnInside: false,
                gallery: { enabled: true }
            });

        });

    };

    function isotopeActivator() {
        if ($('.masonary-layout').length) {
            $('.masonary-layout').isotope({
                layoutMode: 'masonry',
                itemSelector: '.masonary-item',

            });
        }
        if ($('.masonary-layout-no-grid-width').length) {
            $('.masonary-layout-no-grid-width').isotope({
                layoutMode: 'masonry',
                itemSelector: '.masonary-item'
            });
        }

        if ($('.post-filter').length) {
            var postFilterList = $('.post-filter li');
            postFilterList.children('span').on('click', function() {
                var Self = $(this);
                var selector = Self.parent().attr('data-filter');
                postFilterList.children('span').parent().removeClass('active');
                Self.parent().addClass('active');


                $('.filter-layout').isotope({
                    filter: selector,
                    animationOptions: {
                        duration: 500,
                        easing: 'linear',
                        queue: false
                    }
                });
                return false;
            });
        }

        if ($('.post-filter.has-dynamic-filter-counter').length) {
            // var allItem = $('.single-filter-item').length;

            var activeFilterItem = $('.post-filter.has-dynamic-filter-counter').find('li');

            activeFilterItem.each(function() {
                var filterElement = $(this).data('filter');
                var count = $('.gallery-content').find(filterElement).length;
                $(this).children('span').append('<span class="count"><b>' + count + '</b></span>');
            });
        }
    }

    if ($('.video-popup').length) {
        $('.video-popup').magnificPopup({
            disableOn: 700,
            type: 'iframe',
            mainClass: 'mfp-fade',
            removalDelay: 160,
            preloader: true,

            fixedContentPos: false
        });
    }

    if ($('.counter').length) {
        $('.counter').counterUp({
            delay: 10,
            time: 3000
        });
    }

    if ($('.stricky').length) {
        $('.stricky').addClass('original').clone(true).insertAfter('.stricky').addClass('stricked-menu').removeClass('original');
    }


    if ($('.banner-carousel__one').length) {
        $('.banner-carousel__one').owlCarousel({
            loop: true,
            items: 1,
            margin: 0,
            dots: true,
            nav: false,
            animateOut: 'slideOutDown',
            animateIn: 'fadeIn',
            active: true,
            smartSpeed: 1000,
            autoplay: 5000
        });
        $('.banner-carousel-btn .left-btn').on('click', function() {
            $('.banner-carousel__one').trigger('next.owl.carousel');
            return false;
        });
        $('.banner-carousel-btn .right-btn').on('click', function() {
            $('.banner-carousel__one').trigger('prev.owl.carousel');
            return false;
        });
    }





    if ($('.scroll-to-target').length) {
        $(".scroll-to-target").on('click', function() {
            var target = $(this).attr('data-target');
            var offset = $(this).attr('data-target-offset');
            // animate
            $('html, body').animate({
                scrollTop: $(target).offset().top - offset
            }, 1000);

            return false;

        });
    }
    if ($('.appointment-one__switch-wrap').length) {
        $('.appointment-one__switch-wrap').each(function() {
            var Self = $(this);
            var btn = Self.find('.appointment-one__switch');
            var input = Self.find('input[type=hidden]');
            // initial setup
            var inputValue = Self.find('.appointment-one__switch.active').text();
            input.val(inputValue);
            btn.on('click', function() {
                btn.removeClass('active');
                $(this).addClass('active');
                // onclick setup 
                var inputValue = Self.find('.appointment-one__switch.active').text();
                input.val(inputValue);
                console.log(inputValue);
            });

            console.log(inputValue);

        });
    }
    if ($('.contact-form-vaidated').length) {
        $('.contact-form-vaidated').validate({ // initialize the plugin
            rules: {
                name: {
                    required: true
                },
                fname: {
                    required: true
                },
                lname: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                message: {
                    required: true
                },
                subject: {
                    required: true
                },
                booking_date: {
                    required: true
                }
            },
            submitHandler: function(form) {
                // sending value with ajax request
                $.post($(form).attr('action'), $(form).serialize(), function(response) {
                    $(form).parent().find('.result').append(response);
                    $(form).find('input[type="text"]').val('');
                    $(form).find('input[type="email"]').val('');
                    $(form).find('textarea').val('');
                });
                return false;
            }
        });
    }
    if ($('.datepicker').length) {
        $('.datepicker').datepicker();
    }

    if ($('.testimonials-one__carousel').length) {
        if ($('.testimonials-one__carousel').data('carousel-margin') !== undefined) {
            var testicarouselMargin = $('.testimonials-one__carousel').data('carousel-margin');
        } else {
            var testicarouselMargin = 80;
        }
        $('.testimonials-one__carousel').owlCarousel({
            loop: true,
            margin: testicarouselMargin,
            nav: false,
            navText: [
                '<i class="fa fa-long-arrow-left"></i>',
                '<i class="fa fa-long-arrow-right"></i>'
            ],
            dots: true,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 1
                },
                600: {
                    items: 1
                },
                991: {
                    items: 1
                },
                1000: {
                    items: 2
                },
                1200: {
                    items: 2
                }
            }
        });
    }

    if ($('.testimonials-two__carousel').length) {
        $('.testimonials-two__carousel').owlCarousel({
            loop: true,
            margin: 0,
            nav: true,
            navText: [
                '<i class="material-icons">keyboard_arrow_left</i>',
                '<i class="material-icons">keyboard_arrow_right</i>'
            ],
            dots: true,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 1
                },
                600: {
                    items: 1
                },
                991: {
                    items: 1
                },
                1000: {
                    items: 1
                },
                1200: {
                    items: 1
                }
            }
        });
    }

    if ($('.testimonials-three__carousel').length) {
        $('.testimonials-three__carousel').owlCarousel({
            loop: true,
            margin: 30,
            nav: false,
            navText: [
                '<i class="material-icons">keyboard_arrow_left</i>',
                '<i class="material-icons">keyboard_arrow_right</i>'
            ],
            dots: false,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 1
                },
                600: {
                    items: 2
                },
                991: {
                    items: 3
                },
                1000: {
                    items: 3
                },
                1200: {
                    items: 3
                }
            }
        });
    }

    if ($('.recent-products__carousel').length) {
        $('.recent-products__carousel').owlCarousel({
            loop: true,
            margin: 30,
            nav: true,
            navText: [
                '<i class="material-icons">keyboard_arrow_left</i>',
                '<i class="material-icons">keyboard_arrow_right</i>'
            ],
            dots: false,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 1
                },
                600: {
                    items: 2
                },
                991: {
                    items: 3
                },
                1000: {
                    items: 4
                },
                1200: {
                    items: 4
                }
            }
        });
    }
    $(window).on('scroll', function() {
        if ($('.scroll-to-top').length) {
            var strickyScrollPos = 100;
            if ($(window).scrollTop() > strickyScrollPos) {
                $('.scroll-to-top').fadeIn(500);
            } else if ($(this).scrollTop() <= strickyScrollPos) {
                $('.scroll-to-top').fadeOut(500);
            }
        }
        if ($('.stricked-menu').length) {
            var headerScrollPos = 100;
            var stricky = $('.stricked-menu');
            if ($(window).scrollTop() > headerScrollPos) {
                stricky.addClass('stricky-fixed');
            } else if ($(this).scrollTop() <= headerScrollPos) {
                stricky.removeClass('stricky-fixed');
            }
        }
    });
    $(window).on('load', function() {
        isotopeActivator();
        if ($('.preloader').length) {
            $('.preloader').fadeOut('slow');
        }
        if ($('.team-three__slider').length) {
            $('.team-three__slider').bxSlider({
                // adaptiveHeight: true,
                auto: true,
                controls: true,
                nextText: ' ',
                prevText: ' ',
                pause: 5000,
                speed: 500,
                pager: true,
                pagerCustom: '.team-three__pager'
            });
        }
    });

})(jQuery);