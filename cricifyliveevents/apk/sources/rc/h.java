package rc;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f10957a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f10958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f10959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f10960d;

    static {
        Charset.forName("UTF-8");
        Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public h(Executor executor, c cVar, c cVar2) {
        this.f10958b = executor;
        this.f10959c = cVar;
        this.f10960d = cVar2;
    }

    public final void a(qc.g gVar) {
        synchronized (this.f10957a) {
            this.f10957a.add(gVar);
        }
    }
}
