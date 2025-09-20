# ChatHYT User Guide

// Product screenshot goes here


// Product intro goes here
ChatHYT is a simple task manager chatbot with a friendly conversational interface. You can add tasks, set deadlines, mark them as done, and manage your schedule—all in a natural, chat-like environment.

Whether you’re keeping track of assignments, deadlines, or personal todos, ChatHYT helps you stay organized with minimal fuss.

## Adding Tasks

1. Adding Todo 
Command Format: `todo TASK_DESCRIPTION`

Example: `todo Read Chapter 5`

Expected output:
```
Got it! I've added this task:
  [T][ ] Read Chapter 5
Now you have 1 task in the list.
```

2. Adding Deadline

Command Format: `deadline TASK_DESCRIPTION /by DATE_TIME`

Example: `deadline Finish CS2103 ip /by 2025-09-30`

Expected output:
```
Got it! I've added this task:
  [D][ ] Finish CS2103 ip (by: Sep 30 2025)
Now you have 2 tasks in the list.
```

3. Adding Event

Command Format: `event TASK_DESCRIPTION /from DATE_TIME /to DATE_TIME`

Example: `event Project meeting /from 2025-10-01 /to 2025-10-02`

Expected output:
```
Got it! I've added this task:
  [E][ ] Project meeting (from: Oct 1 2025 to: Oct 2 2025)
Now you have 3 tasks in the list.
```

## Managing Tasks

1. mark
   
Command Format: `mark TASK_NUMBER`

Example: `mark 2`

Expected output:
```
Nice! I've marked this task as done:
  [D][X] Finish CS2103 ip (by: Sep 30 2025)
```
2. unmark

Command Format: `unmark TASK_NUMBER`

Example: `unmark 2`

Expected output:

```
Nice! I've marked this task as done:
  [D][ ] Finish CS2103 ip (by: Sep 30 2025)
```

3. delete

Command Format: `delete TASK_NUMBER`

Example: `delete 1`

Expected output:

```
Noted. I've removed this task:
[T][ ] Read Chapter 5
Now you have 2 tasks in the list.
```

## Viewing tasks

1. find

Command Format: `list`

Example: `list`

Expected output:

```
Here are the tasks in your list:
1. [D][ ] Finish CS2103 ip (by: Sep 30 2025)
2. [E][ ] Project meeting (from: Oct 1 2025 to: Oct 2 2025)
```

2. delete

Command Format: `find KEYWORD`

Example: `find project`

Expected output:

```
Here are the tasks in your list:
1. [D][ ] Finish CS2103 ip (by: Sep 30 2025)
2. [E][ ] Project meeting (from: Oct 1 2025 to: Oct 2 2025)
```
3. view by date

Command Format: `view yyyy-mm-dd`

Example: `view 2025-10-01`

Expected output:

```
Tasks on 2025-10-01:
1. [E][ ] Project meeting (from: Oct 1 2025 to: Oct 2 2025)
```

## Exiting the program

Command Format: `bye`

Example: `bye`

Expected output:

```
Bye! Hope to see you again soon.
```