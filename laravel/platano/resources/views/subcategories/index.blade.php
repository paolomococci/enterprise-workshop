@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered subcategories</h3>
	<table class="table" summary="list of registered subcategories">
		<thead>
			<tr class="table-warning">
				<td>id</td>
				<td>todo</td>
				<td class="text-center">action</td>
			</tr>
		</thead>
		<tbody>
			@foreach($subcategory as $subcategories)
			<tr>
				<td>{{$subcategories->id}}</td>
				<td>{{$subcategories->todo}}</td>
				<td class="text-center">
					<nobr>
						<a href="{{ route('subcategories.edit', $subcategories->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
						<form action="{{ route('subcategories.destroy', $subcategories->id)}}" method="post" style="display: inline-block">
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
