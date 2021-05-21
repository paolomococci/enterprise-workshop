@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3>list of registered invoices</h3>
	<table class="table" summary="list of registered invoices">
		<thead>
			<tr class="table-warning">
				<td>id</td>
				<td>todo</td>
				<td class="text-center">action</td>
			</tr>
		</thead>
		<tbody>
			@foreach($invoice as $invoices)
			<tr>
				<td>{{$invoices->id}}</td>
				<td>{{$invoices->todo}}</td>
				<td class="text-center">
					<nobr>
						<a href="{{ route('invoices.edit', $invoices->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
						<form action="{{ route('invoices.destroy', $invoices->id)}}" method="post" style="display: inline-block">
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
