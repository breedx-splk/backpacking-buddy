
# Backpacking Buddy

A contrived/silly demo app that shows how disk buffering should work.

## Concept

It's less about navigation, but it shows fake distance, fake elevation, and allows the user
to choose one of 3 current dispositions as often as they'd like.

The idea was to have one timer that auto-updates the elevation
a random-ish amount, so that it looks like they're moving around, 
maybe 2 times a second. Similarly, another timer would move around the
distance, probably also 2 times a second or so.

Then, another timer would trigger every 10 seconds and report the 
two values (elevation, distance) within a span or event.

The disposition buttons would generate an event immediately.