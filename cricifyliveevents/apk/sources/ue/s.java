package ue;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f12486a = 0;

    static {
        Object objE;
        Object objE2;
        Exception exc = new Exception();
        String simpleName = a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objE = xd.a.class.getCanonicalName();
        } catch (Throwable th) {
            objE = com.bumptech.glide.c.e(th);
        }
        if (rd.h.a(objE) != null) {
            objE = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objE2 = s.class.getCanonicalName();
        } catch (Throwable th2) {
            objE2 = com.bumptech.glide.c.e(th2);
        }
        if (rd.h.a(objE2) != null) {
            objE2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
