@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered tutors</h3>
	<table class="table" summary="list of registered tutors">
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
			@foreach($tutor as $tutors)
			<tr>
				<td>{{$tutors->id}}</td>
				<td>{{$tutors->name}}</td>
				<td>{{$tutors->surname}}</td>
				<td>{{$tutors->email}}</td>
				<td>{{$tutors->phone}}</td>
				<td class="text-center">
					<nobr>
						<a href="{{ route('tutors.edit', $tutors->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
						<form action="{{ route('tutors.destroy', $tutors->id)}}" method="post" style="display: inline-block">
							@csrf
							@method('DELETE')
							<button class="btn btn-danger btn-sm"" type="submit">delete</button>
						</form>
					</nobr>
				</td>
			</tr>
			@endforeach
		</tbody>
	</table>
</div>
@endsection
