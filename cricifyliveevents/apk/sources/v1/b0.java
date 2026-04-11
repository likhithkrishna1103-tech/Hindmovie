package v1;

import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements ta.f, u7.e, hb.e, y1.h, u7.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f12585v;

    public /* synthetic */ b0(int i) {
        this.f12585v = i;
    }

    @Override // y1.h
    public void accept(Object obj) {
        ((ExecutorService) obj).shutdown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0181  */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r5v74, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v75 */
    /* JADX WARN: Type inference failed for: r5v76 */
    /* JADX WARN: Type inference failed for: r5v80, types: [android.text.Spannable, android.text.SpannableString] */
    @Override // ta.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r37) {
        /*
            Method dump skipped, instruction units count: 1512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.b0.apply(java.lang.Object):java.lang.Object");
    }

    @Override // hb.e
    public Object e(dd.c cVar) {
        switch (this.f12585v) {
            case 9:
                return FirebaseSessionsRegistrar.getComponents$lambda$0(cVar);
            case 10:
                return FirebaseSessionsRegistrar.getComponents$lambda$1(cVar);
            case 16:
                return TransportRegistrar.lambda$getComponents$0(cVar);
            case 17:
                return TransportRegistrar.lambda$getComponents$1(cVar);
            default:
                return TransportRegistrar.lambda$getComponents$2(cVar);
        }
    }

    public /* synthetic */ b0(vc.l lVar) {
        this.f12585v = 7;
    }

    @Override // u7.g
    public void a(Exception exc) {
    }
}
