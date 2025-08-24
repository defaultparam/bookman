# Design Overview

The BookMan is for dividing `topics` under different sections, so that one can easily balance work-life balance.

# Commands & Subcommands
- Bookman
	- Research
		- Add
		- Remove
		- List
	- Lifestyle
		- Add
		- Remove
		- List
	- Topics
		- View
		- Update
	
# Options and parameters
- title
- notes
- id (auto-increment)


# Examples usages

`bookman learning add "Git Fundamentals"`
`bookman lifestyle add --title "Gym" --notes "Monday to Friday; Eve (6pm - 8pm IST)"`

`bookman topic view --title "Git Fundamentals"
`bookman topic update --id 2 --notes "Evening; 6pm to 8pm"`