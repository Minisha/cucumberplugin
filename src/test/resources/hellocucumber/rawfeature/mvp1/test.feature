Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  @tag1 @tag2
  Scenario: Sunday isn't Friday
  [Group:id1]Given today is Sunday
  [Group:id2]When I ask whether it's Friday yet
  [Group:id2]Then I should be told "Nope"