package yb;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f14608a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f14609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f14610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f14611d;

    static {
        Charset.forName("UTF-8");
        Pattern.compile("^(1|true|t|yes|y|on)$", 2);
        Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    }

    public h(Executor executor, c cVar, c cVar2) {
        this.f14609b = executor;
        this.f14610c = cVar;
        this.f14611d = cVar2;
    }

    public final void a(xb.g gVar) {
        synchronized (this.f14608a) {
            this.f14608a.add(gVar);
        }
    }
}
