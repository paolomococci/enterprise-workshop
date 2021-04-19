@extends('layouts.master')

@section('content')
<div class="push-top">
	@if(session()->get('success'))
	<div class="alert alert-success">
		{{ session()->get('success') }}
	</div><br/>
	@endif
	<h3><nobr>list of faculties which have a chancellor</nobr></h3>
	<section>
		<h5>list of faculties</h5>
		<table class="table" summary="list of faculties">
			<thead>
				<tr class="table-warning">
					<td>id</td>
					<td>name</td>
					<td>chancellor id</td>
					<td class="text-center">action</td>
				</tr>
			</thead>
			<tbody>
				@foreach($faculty as $faculties)
				<tr>
					<td>{{$faculties->id}}</td>
					<td>{{$faculties->name}}</td>
					<td>{{$faculties->chancellor_id}}</td>
					<td class="text-center">
						<nobr>
							<a href="{{ route('faculties.edit', $faculties->id)}}" class="btn btn-outline-success btn-sm"">edit</a>
							<form action="{{ route('faculties.destroy', $faculties->id)}}" method="post" style="display: inline-block">
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
	</section>
	<section>
		<h5>list of chancellors</h5>
		<table class="table" summary="list of chancellors">
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
	</section>
</div>
@endsection
