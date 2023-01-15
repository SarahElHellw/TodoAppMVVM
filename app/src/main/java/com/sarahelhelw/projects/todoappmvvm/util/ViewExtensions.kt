package com.sarahelhelw.projects.todoappmvvm.util

import androidx.appcompat.widget.SearchView

/**
 * We implemented an extension function on the SearchView
 * to eliminate the boilerplate code
 *
 * We use inline keyword with functions that accept other functions as
 * parameters to decrease memory allocations of lambda expressions
 * and decrease runtime overhead and enhance performance
 *
 * can't call high order functions in callback methods without crossinline
 * keyword as we will get compilation error
 */
inline fun SearchView.onQueryTextChanged(crossinline listener: (String) -> Unit) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true // this method is called if the submit button is pressed
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            listener(newText.orEmpty())
            return true
        }
    })
}