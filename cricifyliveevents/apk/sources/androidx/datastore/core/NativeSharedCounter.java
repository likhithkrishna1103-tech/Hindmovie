package androidx.datastore.core;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class NativeSharedCounter {
    public final native long nativeCreateSharedCounter(int i);

    public final native int nativeGetCounterValue(long j4);

    public final native int nativeIncrementAndGetCounterValue(long j4);

    public final native int nativeTruncateFile(int i);
}
