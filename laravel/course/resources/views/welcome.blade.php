<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="{{ url('css/welcome.css')}}" type="text/css" media="screen"/>
        <title>course</title>
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
                    course
                </div>

                @isset($tutors)
                    <div class="container mt-5">
                        <table class="table table-inverse">
                            <thead>
                                <tr>
                                    <th>tutor identifier</th>
                                    <th>name</th>
                                    <th>surname</th>
                                    <th>email</th>
                                </tr>
                            </thead>
                            <tbody>
                                @foreach($tutors as $tutor)
                                    <tr id="tutor{{$tutor->id}}">
                                        <td>{{$tutor->id}}</td>
                                        <td>{{$tutor->name}}</td>
                                        <td>{{$tutor->surname}}</td>
                                        <td>{{$tutor->email}}</td>
                                    </tr>
                                @endforeach
                            </tbody>
                        </table>
                    </div>
                @endisset

                <div class="links">
                    <a href="#">todo</a>
                    <a href="#">todo</a>
                    <a href="#">todo</a>
                    <a href="#">todo</a>
                    <a href="#">todo</a>
                </div>
            </div>
        </div>
    </body>
</html>
