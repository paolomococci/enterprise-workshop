@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered chancellors</h3>
	<table class="table" summary="list of registered chancellors">
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
			@foreach($chancellor as $chancellors)
			<tr>
				<td>{{$chancellors->id}}</td>
				<td>{{$chancellors->name}}</td>
				<td>{{$chancellors->surname}}</td>
				<td>{{$chancellors->email}}</td>
				<td>{{$chancellors->phone}}</td>
				<td class="text-center">
					<nobr>
						<a href="{{ route('chancellors.edit', $chancellors->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
						<form action="{{ route('chancellors.destroy', $chancellors->id)}}" method="post" style="display: inline-block">
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
