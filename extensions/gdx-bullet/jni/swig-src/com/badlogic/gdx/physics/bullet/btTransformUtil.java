/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.4
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.badlogic.gdx.physics.bullet;

import com.badlogic.gdx.utils.SharedLibraryLoader;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Matrix3;

public class btTransformUtil {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public btTransformUtil(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(btTransformUtil obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gdxBulletJNI.delete_btTransformUtil(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  static {
    new SharedLibraryLoader().load("gdx-bullet");
  }

  public static void integrateTransform(btTransform curTrans, Vector3 linvel, Vector3 angvel, float timeStep, btTransform predictedTransform) {
    gdxBulletJNI.btTransformUtil_integrateTransform(btTransform.getCPtr(curTrans), curTrans, linvel, angvel, timeStep, btTransform.getCPtr(predictedTransform), predictedTransform);
  }

  public static void calculateVelocityQuaternion(Vector3 pos0, Vector3 pos1, Quaternion orn0, Quaternion orn1, float timeStep, Vector3 linVel, Vector3 angVel) {
    gdxBulletJNI.btTransformUtil_calculateVelocityQuaternion(pos0, pos1, orn0, orn1, timeStep, linVel, angVel);
  }

  public static void calculateDiffAxisAngleQuaternion(Quaternion orn0, Quaternion orn1a, Vector3 axis, SWIGTYPE_p_float angle) {
    gdxBulletJNI.btTransformUtil_calculateDiffAxisAngleQuaternion(orn0, orn1a, axis, SWIGTYPE_p_float.getCPtr(angle));
  }

  public static void calculateVelocity(btTransform transform0, btTransform transform1, float timeStep, Vector3 linVel, Vector3 angVel) {
    gdxBulletJNI.btTransformUtil_calculateVelocity(btTransform.getCPtr(transform0), transform0, btTransform.getCPtr(transform1), transform1, timeStep, linVel, angVel);
  }

  public static void calculateDiffAxisAngle(btTransform transform0, btTransform transform1, Vector3 axis, SWIGTYPE_p_float angle) {
    gdxBulletJNI.btTransformUtil_calculateDiffAxisAngle(btTransform.getCPtr(transform0), transform0, btTransform.getCPtr(transform1), transform1, axis, SWIGTYPE_p_float.getCPtr(angle));
  }

  public btTransformUtil() {
    this(gdxBulletJNI.new_btTransformUtil(), true);
  }

}