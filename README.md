# CS441_Drawing
## Objective
This project displays 3 adjustable lines that the user can move around the screen at-will. There are two sliders at the top of the screen which each control either the angle or the y-intercept of the active line. Below the seekbars are buttons that can be pressed to pick between the 3 different lines and change the active line. There are text fields that display which line is active, and the angle/y-intercept of the active line.

This project makes use of a custom class that extends surfaceview. This class is able to handle three indpendent lines and track the important information about them. The DrawSurface creates a black background and draws 3 lines, One red, one Blue, and one Green. This app also makes use of dynamically updating the attributes of various objects, from words on TextViews to the position of sliders on SeekBars.

## Production Log
**9/9/19:** Began project. Defined buttons and LinearLayouts so that next time I can get right into writing new and meaningful code.

**9/11/19:**  Created getters and setters, attempted to place a circle on the screen with a transparent background.

**9/13/19:** Changed scope of project to displaying adjustable lines instead of a free-form drawing board. Scrapped code and started with new sample code to work with.

**9/17/19:** Created back-end functionality to adjust a line on the screen by its slope

**9/18/19:** Made it possible to completely adjust a line's y-intercept and slope

**9/20/19:** Adjusted calculations so that lines can be manipulated based on their angles and y-intercepts

**9/22/19:** The app now can display 3 different lines that can each be adjusted independently and selected at will.
