// ==UserScript== 
// @name Unnerviks github pull request file list expander 
// @namespace http://www.unnervik.se 
// @description Expands the narrow file list in github PRs 
// @match https://github.com/*/*/pull/*/files
// ==/UserScript== 

discussion = document.getElementsByClassName ("container new-discussion-timeline experiment-repo-nav  ");
if (discussion.length == 1) {
  discussion[0].style.width = '96%'
} else {
	alert('Annoying Grease monkey warning: Could not find the right node in the DOM to change style width on')
}
