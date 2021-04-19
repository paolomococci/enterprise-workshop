@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered teachers</h3>
	<table class="table" summary="list of registered teachers">
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
			@foreach($teacher as $teachers)
			<tr>
				<td>{{$teachers->id}}</td>
				<td>{{$teachers->name}}</td>
				<td>{{$teachers->surname}}</td>
				<td>{{$teachers->email}}</td>
				<td>{{$teachers->phone}}</td>
				<td class="text-center">
					<nobr>
						<a href="{{ route('teachers.edit', $teachers->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
						<form action="{{ route('teachers.destroy', $teachers->id)}}" method="post" style="display: inline-block">
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
