package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public interface j0 extends IInterface {
    void beginAdUnitExposure(String str, long j4);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j4);

    void endAdUnitExposure(String str, long j4);

    void generateEventId(l0 l0Var);

    void getAppInstanceId(l0 l0Var);

    void getCachedAppInstanceId(l0 l0Var);

    void getConditionalUserProperties(String str, String str2, l0 l0Var);

    void getCurrentScreenClass(l0 l0Var);

    void getCurrentScreenName(l0 l0Var);

    void getGmpAppId(l0 l0Var);

    void getMaxUserProperties(String str, l0 l0Var);

    void getSessionId(l0 l0Var);

    void getTestFlag(l0 l0Var, int i);

    void getUserProperties(String str, String str2, boolean z10, l0 l0Var);

    void initForTests(Map map);

    void initialize(v8.a aVar, t0 t0Var, long j4);

    void isDataCollectionEnabled(l0 l0Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j4);

    void logEventAndBundle(String str, String str2, Bundle bundle, l0 l0Var, long j4);

    void logHealthData(int i, String str, v8.a aVar, v8.a aVar2, v8.a aVar3);

    void onActivityCreated(v8.a aVar, Bundle bundle, long j4);

    void onActivityCreatedByScionActivityInfo(v0 v0Var, Bundle bundle, long j4);

    void onActivityDestroyed(v8.a aVar, long j4);

    void onActivityDestroyedByScionActivityInfo(v0 v0Var, long j4);

    void onActivityPaused(v8.a aVar, long j4);

    void onActivityPausedByScionActivityInfo(v0 v0Var, long j4);

    void onActivityResumed(v8.a aVar, long j4);

    void onActivityResumedByScionActivityInfo(v0 v0Var, long j4);

    void onActivitySaveInstanceState(v8.a aVar, l0 l0Var, long j4);

    void onActivitySaveInstanceStateByScionActivityInfo(v0 v0Var, l0 l0Var, long j4);

    void onActivityStarted(v8.a aVar, long j4);

    void onActivityStartedByScionActivityInfo(v0 v0Var, long j4);

    void onActivityStopped(v8.a aVar, long j4);

    void onActivityStoppedByScionActivityInfo(v0 v0Var, long j4);

    void performAction(Bundle bundle, l0 l0Var, long j4);

    void registerOnMeasurementEventListener(q0 q0Var);

    void resetAnalyticsData(long j4);

    void retrieveAndUploadBatches(n0 n0Var);

    void setConditionalUserProperty(Bundle bundle, long j4);

    void setConsent(Bundle bundle, long j4);

    void setConsentThirdParty(Bundle bundle, long j4);

    void setCurrentScreen(v8.a aVar, String str, String str2, long j4);

    void setCurrentScreenByScionActivityInfo(v0 v0Var, String str, String str2, long j4);

    void setDataCollectionEnabled(boolean z10);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(q0 q0Var);

    void setInstanceIdProvider(s0 s0Var);

    void setMeasurementEnabled(boolean z10, long j4);

    void setMinimumSessionDuration(long j4);

    void setSessionTimeoutDuration(long j4);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j4);

    void setUserProperty(String str, String str2, v8.a aVar, boolean z10, long j4);

    void unregisterOnMeasurementEventListener(q0 q0Var);
}
