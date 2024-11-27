# Doppelganger

*Goal*: learn about the various types of test doubles

## Instructions

There are bugs in the code (marked with a `Bug!` comment), but all the
tests are passing.

For each test, you will find a `TODO` comment. Your job
is to finish the implementation of each test and make them fail for the right reason, i.e, triggering
the bugs. You must do so by **adding only test code** - you
are not allowed to change the production code.

Here's the order in which you should fix the test - they go from easiest to trickiest :)

1. SafeCalculator
1. DiscountApplier
1. MailSender

## Part 1 - without any library

For this part, you are not allowed to add any external mock library (using the test framework is ok)

Start by writing the tests naively - and then make it run (or compile) by adding clases
to the test code (this is what we call a test double).


## Part 2 - with a library

Use a library like `mockito` for Java, `unittest.mock` for Python or
`sinon` for JavaScript to rewrite all the tests.

## Part 3 - debrief

Which version do you prefer? Why?


