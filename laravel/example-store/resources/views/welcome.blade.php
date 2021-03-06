<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- the following solutions are in fact equivalent, but I prefer the latter -->
        <!--link rel="stylesheet" href="http://127.0.0.1:8000/css/welcome.css" type="text/css" media="screen"/-->
        <link rel="stylesheet" href="{{ url('css/welcome.css')}}" type="text/css" media="screen"/>
        
        <title>example store</title>
    </head>
    <body>
        <div class="flex-center position-ref full-height">
            @if (Route::has('login'))
                <div class="top-right links">
                    @auth
                        <a href="{{ url('/home') }}">home</a>
                    @else
                        <a href="{{ route('login') }}">login</a>

                        @if (Route::has('register'))
                            <a href="{{ route('register') }}">register</a>
                        @endif
                    @endauth
                </div>
            @endif

            <div class="content">
                <div class="title m-b-md">
                    example store
                </div>

                <div class="links">
                    <a href="#">docs</a>
                    <a href="#">examples</a>
                    <a href="#">news</a>
                    <a href="#">blog</a>
                    <a href="#">todo</a>
                    <a href="#">todo</a>
                    <a href="#">todo</a>
                    <a href="#">todo</a>
                </div>
            </div>
        </div>
    </body>
</html>
