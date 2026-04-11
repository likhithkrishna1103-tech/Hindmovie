package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public interface s0 extends IInterface {
    void beginAdUnitExposure(String str, long j5);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j5);

    void endAdUnitExposure(String str, long j5);

    void generateEventId(w0 w0Var);

    void getAppInstanceId(w0 w0Var);

    void getCachedAppInstanceId(w0 w0Var);

    void getConditionalUserProperties(String str, String str2, w0 w0Var);

    void getCurrentScreenClass(w0 w0Var);

    void getCurrentScreenName(w0 w0Var);

    void getGmpAppId(w0 w0Var);

    void getMaxUserProperties(String str, w0 w0Var);

    void getSessionId(w0 w0Var);

    void getTestFlag(w0 w0Var, int i);

    void getUserProperties(String str, String str2, boolean z2, w0 w0Var);

    void initForTests(Map map);

    void initialize(a8.a aVar, d1 d1Var, long j5);

    void isDataCollectionEnabled(w0 w0Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z10, long j5);

    void logEventAndBundle(String str, String str2, Bundle bundle, w0 w0Var, long j5);

    void logHealthData(int i, String str, a8.a aVar, a8.a aVar2, a8.a aVar3);

    void onActivityCreated(a8.a aVar, Bundle bundle, long j5);

    void onActivityDestroyed(a8.a aVar, long j5);

    void onActivityPaused(a8.a aVar, long j5);

    void onActivityResumed(a8.a aVar, long j5);

    void onActivitySaveInstanceState(a8.a aVar, w0 w0Var, long j5);

    void onActivityStarted(a8.a aVar, long j5);

    void onActivityStopped(a8.a aVar, long j5);

    void performAction(Bundle bundle, w0 w0Var, long j5);

    void registerOnMeasurementEventListener(x0 x0Var);

    void resetAnalyticsData(long j5);

    void setConditionalUserProperty(Bundle bundle, long j5);

    void setConsent(Bundle bundle, long j5);

    void setConsentThirdParty(Bundle bundle, long j5);

    void setCurrentScreen(a8.a aVar, String str, String str2, long j5);

    void setDataCollectionEnabled(boolean z2);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(x0 x0Var);

    void setInstanceIdProvider(b1 b1Var);

    void setMeasurementEnabled(boolean z2, long j5);

    void setMinimumSessionDuration(long j5);

    void setSessionTimeoutDuration(long j5);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j5);

    void setUserProperty(String str, String str2, a8.a aVar, boolean z2, long j5);

    void unregisterOnMeasurementEventListener(x0 x0Var);
}
