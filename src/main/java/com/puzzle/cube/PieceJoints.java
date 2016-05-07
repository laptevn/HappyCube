package com.puzzle.cube;

import com.puzzle.core.SideType;

import java.util.HashMap;
import java.util.Map;

class PieceJoints {
    private final Map<SideType, JointInfo> joints = new HashMap<>();

    public JointInfo getJointInfo(SideType side) {
        return joints.get(side);
    }

    public PieceJoints withJoint(SideType side, JointInfo jointInfo) {
        joints.put(side, jointInfo);
        return this;
    }
}