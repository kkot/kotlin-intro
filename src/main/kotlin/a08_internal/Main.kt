package a08_internal

import a08_internal.subpackage.not_directory.Internal

fun main(args: Array<String>) {
    Internal() // we can access a08_internal between packages, also package name might be different then directory name
}