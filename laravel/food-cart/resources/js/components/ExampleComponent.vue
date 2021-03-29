<template>
    <section class="container">
        <aside class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">sample component</div>
                    <div class="card-body">
                        sample component
                    </div>
                </div>
            </div>
        </aside>
    </section>
</template>

<script>

export default {
    name: 'ExampleComponent'
    mounted() {
	console.log('sample component mounted')
    }
}
</script>
