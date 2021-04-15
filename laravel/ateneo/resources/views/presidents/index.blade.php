@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of presidents who have alternated</h3>
	<table class="table" summary="list of presidents who have alternated">
		<thead>
			<tr class="table-warning">
				<td>id</td>
				<td>name</td>
				<td>surname</td>
				<td>email</td>
				<td>phone</td>
				<td class="text-center">action</td>
			</tr>
		</thead>
		<tbody>
			@foreach($president as $presidents)
			<tr>
				<td>{{$presidents->id}}</td>
				<td>{{$presidents->name}}</td>
				<td>{{$presidents->surname}}</td>
				<td>{{$presidents->email}}</td>
				<td>{{$presidents->phone}}</td>
				<td class="text-center">
					<a href="{{ route('presidents.edit', $presidents->id)}}" class="btn btn-primary btn-sm"">edit</a>
					<form action="{{ route('presidents.destroy', $presidents->id)}}" method="post" style="display: inline-block">
						@csrf
						@method('DELETE')
						<button class="btn btn-danger btn-sm"" type="submit">delete</button>
					</form>
				</td>
			</tr>
			@endforeach
		</tbody>
	</table>
</div>
@endsection
