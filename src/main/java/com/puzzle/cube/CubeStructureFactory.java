package com.puzzle.cube;

import com.puzzle.core.*;

import java.util.ArrayList;
import java.util.List;

class CubeStructureFactory {
    public List<PieceJoints> create() {
        List<PieceJoints> dependencies = new ArrayList<>(Constants.PIECES_COUNT);

        Vertex vertex0_4_5 = new Vertex();
        Vertex vertex0_1_5 = new Vertex();
        Vertex vertex0_3_4 = new Vertex();
        Vertex vertex0_1_3 = new Vertex();
        Vertex vertex2_1_5 = new Vertex();
        Vertex vertex2_4_5 = new Vertex();
        Vertex vertex2_1_3 = new Vertex();
        Vertex vertex2_3_4 = new Vertex();

        dependencies.add(0,
                new PieceJoints()
                        .withJoint(SideType.TOP,
                                new JointInfo()
                                        .withPieceIndex(5)
                                        .withSideType(SideType.LEFT)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_4_5)
                                        .withVertex2(vertex0_1_5))
                        .withJoint(SideType.BOTTOM,
                                new JointInfo()
                                        .withPieceIndex(3)
                                        .withSideType(SideType.LEFT)
                                        .withIsReserved(true)
                                        .withVertex1(vertex0_3_4)
                                        .withVertex2(vertex0_1_3))
                        .withJoint(SideType.LEFT,
                                new JointInfo()
                                        .withPieceIndex(4)
                                        .withSideType(SideType.LEFT)
                                        .withIsReserved(true)
                                        .withVertex1(vertex0_4_5)
                                        .withVertex2(vertex0_3_4))
                        .withJoint(SideType.RIGHT,
                                new JointInfo()
                                        .withPieceIndex(1)
                                        .withSideType(SideType.LEFT)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_1_5)
                                        .withVertex2(vertex0_1_3)));

        dependencies.add(1,
                new PieceJoints()
                        .withJoint(SideType.TOP,
                                new JointInfo()
                                        .withPieceIndex(5)
                                        .withSideType(SideType.BOTTOM)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_1_5)
                                        .withVertex2(vertex2_1_5))
                        .withJoint(SideType.BOTTOM,
                                new JointInfo()
                                        .withPieceIndex(3)
                                        .withSideType(SideType.TOP)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_1_3)
                                        .withVertex2(vertex2_1_3))
                        .withJoint(SideType.LEFT,
                                new JointInfo()
                                        .withPieceIndex(0)
                                        .withSideType(SideType.RIGHT)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_1_5)
                                        .withVertex2(vertex0_1_3))
                        .withJoint(SideType.RIGHT,
                                new JointInfo()
                                        .withPieceIndex(2)
                                        .withSideType(SideType.LEFT)
                                        .withIsReserved(false)
                                        .withVertex1(vertex2_1_5)
                                        .withVertex2(vertex2_1_3)));

        dependencies.add(2,
                new PieceJoints()
                        .withJoint(SideType.TOP,
                                new JointInfo()
                                        .withPieceIndex(5)
                                        .withSideType(SideType.RIGHT)
                                        .withIsReserved(true)
                                        .withVertex1(vertex2_1_5)
                                        .withVertex2(vertex2_4_5))
                        .withJoint(SideType.BOTTOM,
                                new JointInfo()
                                        .withPieceIndex(3)
                                        .withSideType(SideType.RIGHT)
                                        .withIsReserved(false)
                                        .withVertex1(vertex2_1_3)
                                        .withVertex2(vertex2_3_4))
                        .withJoint(SideType.LEFT,
                                new JointInfo()
                                        .withPieceIndex(1)
                                        .withSideType(SideType.RIGHT)
                                        .withIsReserved(false)
                                        .withVertex1(vertex2_1_5)
                                        .withVertex2(vertex2_1_3))
                        .withJoint(SideType.RIGHT,
                                new JointInfo()
                                        .withPieceIndex(4)
                                        .withSideType(SideType.RIGHT)
                                        .withIsReserved(true)
                                        .withVertex1(vertex2_4_5)
                                        .withVertex2(vertex2_3_4)));

        dependencies.add(3,
                new PieceJoints()
                        .withJoint(SideType.TOP,
                                new JointInfo()
                                        .withPieceIndex(1)
                                        .withSideType(SideType.BOTTOM)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_1_3)
                                        .withVertex2(vertex2_1_3))
                        .withJoint(SideType.BOTTOM,
                                new JointInfo()
                                        .withPieceIndex(4)
                                        .withSideType(SideType.TOP)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_3_4)
                                        .withVertex2(vertex2_3_4))
                        .withJoint(SideType.LEFT,
                                new JointInfo()
                                        .withPieceIndex(0)
                                        .withSideType(SideType.BOTTOM)
                                        .withIsReserved(true)
                                        .withVertex1(vertex0_1_3)
                                        .withVertex2(vertex0_3_4))
                        .withJoint(SideType.RIGHT,
                                new JointInfo()
                                        .withPieceIndex(2)
                                        .withSideType(SideType.BOTTOM)
                                        .withIsReserved(false)
                                        .withVertex1(vertex2_1_3)
                                        .withVertex2(vertex2_3_4)));

        dependencies.add(4,
                new PieceJoints()
                        .withJoint(SideType.TOP,
                                new JointInfo()
                                        .withPieceIndex(3)
                                        .withSideType(SideType.BOTTOM)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_3_4)
                                        .withVertex2(vertex2_3_4))
                        .withJoint(SideType.BOTTOM,
                                new JointInfo()
                                        .withPieceIndex(5)
                                        .withSideType(SideType.TOP)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_4_5)
                                        .withVertex2(vertex2_4_5))
                        .withJoint(SideType.LEFT,
                                new JointInfo()
                                        .withPieceIndex(0)
                                        .withSideType(SideType.LEFT)
                                        .withIsReserved(true)
                                        .withVertex1(vertex0_3_4)
                                        .withVertex2(vertex0_4_5))
                        .withJoint(SideType.RIGHT,
                                new JointInfo()
                                        .withPieceIndex(2)
                                        .withSideType(SideType.RIGHT)
                                        .withIsReserved(true)
                                        .withVertex1(vertex2_3_4)
                                        .withVertex2(vertex2_4_5)));

        dependencies.add(5,
                new PieceJoints()
                        .withJoint(SideType.TOP,
                                new JointInfo()
                                        .withPieceIndex(4)
                                        .withSideType(SideType.BOTTOM)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_4_5)
                                        .withVertex2(vertex2_4_5))
                        .withJoint(SideType.BOTTOM,
                                new JointInfo()
                                        .withPieceIndex(1)
                                        .withSideType(SideType.TOP)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_1_5)
                                        .withVertex2(vertex2_1_5))
                        .withJoint(SideType.LEFT,
                                new JointInfo()
                                        .withPieceIndex(0)
                                        .withSideType(SideType.TOP)
                                        .withIsReserved(false)
                                        .withVertex1(vertex0_4_5)
                                        .withVertex2(vertex0_1_5))
                        .withJoint(SideType.RIGHT,
                                new JointInfo()
                                        .withPieceIndex(2)
                                        .withSideType(SideType.TOP)
                                        .withIsReserved(true)
                                        .withVertex1(vertex2_4_5)
                                        .withVertex2(vertex2_1_5)));

        return dependencies;
    }
}