package pe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f10400a = 0;

    static {
        Object objH;
        Object objH2;
        Exception exc = new Exception();
        String simpleName = a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objH = td.a.class.getCanonicalName();
        } catch (Throwable th) {
            objH = i5.a.h(th);
        }
        if (nd.h.a(objH) != null) {
            objH = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objH2 = s.class.getCanonicalName();
        } catch (Throwable th2) {
            objH2 = i5.a.h(th2);
        }
        if (nd.h.a(objH2) != null) {
            objH2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
