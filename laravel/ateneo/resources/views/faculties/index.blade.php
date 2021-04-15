@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3></h3>
	<table class="table" summary="">
		<thead>
			<tr class="table-warning">
				<td>id</td>
				<td>name</td>
				<td class="text-center">action</td>
			</tr>
		</thead>
		<tbody>
			@foreach($faculty as $faculties)
			<tr>
				<td>{{$faculties->id}}</td>
				<td>{{$faculties->name}}</td>
				<td class="text-center">
					<a href="{{ route('faculties.edit', $faculties->id)}}" class="btn btn-primary btn-sm"">edit</a>
					<form action="{{ route('faculties.destroy', $faculties->id)}}" method="post" style="display: inline-block">
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
