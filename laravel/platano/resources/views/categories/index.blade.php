@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered categories</h3>
	<table class="table" summary="list of registered categories">
		<thead>
			<tr class="table-warning">
				<td>id</td>
				<td>name</td>
				<td class="text-center">action</td>
			</tr>
		</thead>
		<tbody>
			@foreach($category as $categories)
			<tr>
				<td>{{$categories->id}}</td>
				<td>{{$categories->name}}</td>
				<td class="text-center">
					<nobr>
						<a href="{{ route('categories.edit', $categories->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
						<form action="{{ route('categories.destroy', $categories->id)}}" method="post" style="display: inline-block">
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
