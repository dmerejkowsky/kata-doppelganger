const answer = require('./index')
const test = require('tape')

test('it works', (t) => {
  t.equal(answer(), 42)
  t.end()
})
