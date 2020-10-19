package FooBar;

/*
Elevator Maintenance
====================

You've been assigned the onerous task of elevator maintenance - ugh! It wouldn't be so bad, except that all the elevator documentation has been lying in a disorganized pile at the bottom of a filing cabinet for years, and you don't even know what elevator version numbers you'll be working on.

Elevator versions are represented by a series of numbers, divided up into major, minor and revision integers. New versions of an elevator increase the major number, e.g. 1, 2, 3, and so on. When new features are added to an elevator without being a complete new version, a second number named "minor" can be used to represent those new additions, e.g. 1.0, 1.1, 1.2, etc. Small fixes or maintenance work can be represented by a third number named "revision", e.g. 1.1.1, 1.1.2, 1.2.0, and so on. The number zero can be used as a major for pre-release versions of elevators, e.g. 0.1, 0.5, 0.9.2, etc (Commander Lambda is careful to always beta test her new technology, with her loyal henchmen as subjects!).

Given a list of elevator versions represented as strings, write a function solution(l) that returns the same list sorted in ascending order by major, minor, and revision number so that you can identify the current elevator version. The versions in list l will always contain major numbers, but minor and revision numbers are optional. If the version contains a revision number, then it will also have a minor number.

For example, given the list l as ["1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"], the function solution(l) would return the list ["1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"]. If two or more versions are equivalent but one version contains more numbers than the others, then these versions must be sorted ascending based on how many numbers they have, e.g ["1", "1.0", "1.0.0"]. The number of elements in the list l will be at least 1 and will not exceed 100.

Languages
=========
To provide a Java solution, edit Solution.java

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

-- Java cases --
Input:
Solution.solution({"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"})
Output:
    0.1,1.1.1,1.2,1.2.1,1.11,2,2.0,2.0.0

Input:
Solution.solution({"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"})
Output:
    1.0,1.0.2,1.0.12,1.1.2,1.3.3
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Solution2 {
    public static String[] solution(String[] l) {
        if (l == null || l.length == 0) {
            return new String[]{};
        }

        List<ElevatorVersion> versions = new ArrayList<>();
        for (String s : l) {
            ElevatorVersion elevatorVersion = new ElevatorVersion(0, 0, 0, s.length(), VersionType.UNKNOWN);
            composeElevatorVersion(s, elevatorVersion);
            versions.add(elevatorVersion);
        }

        versions.sort(new ElevatorVersion.VersionComparator());

        String[] answer = new String[l.length];
        for (int i = 0; i < l.length; i++) {
            answer[i] = versions.get(i).toString();
        }

        return answer;
    }

    private static void composeElevatorVersion(String rawVersion, ElevatorVersion elevatorVersion) {
        char versionDelimiter = '.';
        if (rawVersion.indexOf(versionDelimiter) >= 0) {
            int versionIndex = rawVersion.indexOf(versionDelimiter);
            elevatorVersion.major = Integer.parseInt(rawVersion.substring(0, versionIndex));
            rawVersion = rawVersion.substring(versionIndex + 1);

            if (!rawVersion.isEmpty()) {
                elevatorVersion.type = VersionType.MAJOR_MINOR;
            }

            if (rawVersion.indexOf(versionDelimiter) >= 0) {
                versionIndex = rawVersion.indexOf(versionDelimiter);
                elevatorVersion.minor = Integer.parseInt(rawVersion.substring(0, versionIndex));
                rawVersion = rawVersion.substring(versionIndex + 1);

                if (!rawVersion.isEmpty()) {
                    elevatorVersion.type = VersionType.MAJOR_MINOR_REVISION;
                }
                elevatorVersion.revision = Integer.parseInt(rawVersion);
            } else {
                elevatorVersion.minor = Integer.parseInt(rawVersion);
            }
        } else {
            elevatorVersion.major = Integer.parseInt(rawVersion);
            elevatorVersion.type = VersionType.MAJOR;
        }
    }

    @Test
    public void test() {
       System.out.println(solution(new String[]{"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"}));
    }
}

enum VersionType {
    UNKNOWN(0),
    MAJOR(1),
    MAJOR_MINOR(2),
    MAJOR_MINOR_REVISION(3);

    public final int version;

    VersionType(int version) {
        this.version = version;
    }
}

class ElevatorVersion {
    int major;
    int minor;
    int revision;
    int length;
    VersionType type;

    ElevatorVersion(int major, int minor, int revision, int length, VersionType type) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
        this.length = length;
        this.type = type;
    }

    static class VersionComparator implements Comparator<ElevatorVersion> {
        @Override
        public int compare(ElevatorVersion a, ElevatorVersion b) {
            int major = Integer.compare(a.major, b.major);
            if (major !=0) return major;

            int minor = Integer.compare(a.minor, b.minor);
            if (minor !=0) return minor;

            int revision = Integer.compare(a.revision, b.revision);
            if (revision !=0) return revision;

            return Integer.compare(a.length, b.length);
        }
    }

    @Override
    public String toString() {
        if (type == VersionType.MAJOR)
            return String.format("%d", major);
        else if (type == VersionType.MAJOR_MINOR)
            return String.format("%d.%d", major, minor);
        if (type == VersionType.MAJOR_MINOR_REVISION)
            return String.format("%d.%d.%d", major, minor, revision);
        else
            return "";
    }
}