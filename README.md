## TOC

* Purposes Of Testing
* Characteristics Of a Good Test
* Maximizing ROI


## Purposes Of Testing

* Communication
* Regression
* Acceptance Criteria Medium
* Confidence

## Characteristics Of a Good Test

* Effectively Communicative
* Focused
* Fast
* Structured

## Maximizing ROI

* Ideal:
        * test count: infinity
        * time cost to introduce: 0
        * time to maintain: 0

* Solution: automate everything you can automate

## Difficult testing situations:

* Testing beans':
      * Getters
      * Setters
      * ToString
      * Equals
      * HashCode

* Writing Communicative Tests: Structured BDD/Jbehave/Groovy/Spoke

## Statistics:

	------------------------------------------------------------------
	| Criteria                     | Spock    | Groovy    | Java     |
	------------------------------------------------------------------
	| Characters                   | 1780     | 2933      | 3097     |
	| Characters (w/o spaces)      | 1052     | 2069      | 2281     |
	| Number of Words              | 163      | 278       | 230      |
	| Number of Sentences          | 64       | 113       | 111      |
	| Number of Paragraphs         | 49       | 87        | 86       |
	| Number of Difficult Words    | 58 (36%) | 135 (49%) | 94 (41%) |
	| Number of Unique Words       | 68 (42%) | 73  (26%) | 61 (27%) |
	| Short Words (<5 characters)  | 85 (52%) | 110 (40%) | 69 (30%) |
	| Avg. Word Length (char)      | 6.5      | 7.4       | 9.9      |
	| Avg. Sentence Length (word)  | 2.5      | 2.5       | 2.1      |
	| Dale-Chall Readability Score | 9.4      | 11.4      | 10.2     |
	| Readability level            | 13-15th  | graduate  | graduate |
	------------------------------------------------------------------                                  s




results from website:        [https://readability-score.com](https://readability-score.com "Readability Score")

## Reading Ease

* A higher score indicates easier readability; scores usually range between 0 and 100.

         -----------------------------------------------------------
         | Readability Formula    | Score |  Spock | Groovy | Java |
         -----------------------------------------------------------
         | Flesch-Kincaid Reading | Ease  |  50.6  | 35.2   | 6.6  |
         -----------------------------------------------------------

## Grade Levels

* A grade level (based on the USA education system) is equivalent to the number of years of education a person has had. A score of around 10-12 is roughly the reading level on completion of high school. Text to be read by the general public should aim for a grade level of around 8.

        -------------------------------------------------------
        | Readability Formula         |	Spock | Groovy | Java |
        -------------------------------------------------------
        | Flesch-Kincaid Grade Level  |	7.7   | 9.8    | 13.7 |
        | Gunning-Fog Score           |	8.3   | 10.6   | 11.7 |
        | Coleman-Liau Index	      |  12.4 | 17     | 23.1 |
        | SMOG Index                  |	6     | 6.8    | 6.8  |
        | Automated Readability Index |	4.1   | 7.8    | 12.4 |
        | Average Grade Level	      | 7.7   | 10.4   | 13.5 |
        -------------------------------------------------------

## Text Statistics

        -----------------------------------------------
        | Item                | Spock | Groovy | Java |
        -----------------------------------------------
        | Character Count     |	877   | 1780   | 1897 |
        | Syllable Count      |	325   | 625    | 661  |
        | Word Count	      | 183   | 319    | 287  |
        | Sentence Count      |	31    | 55     | 54   |
        | Characters per Word |	4.8   | 5.6    | 6.6  |
        | Syllables per Word  |	1.8   | 2.0    | 2.3  |
        | Words per Sentence  |	5.9   | 5.8    | 5.3  |
        -----------------------------------------------