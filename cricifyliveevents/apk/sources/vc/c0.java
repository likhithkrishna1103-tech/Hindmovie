package vc;

import android.content.Context;
import android.os.Process;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rd.j f13588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rd.j f13590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rd.j f13591e;
    public boolean f;

    public c0(Context context, f1 f1Var) {
        ge.i.e(context, "appContext");
        ge.i.e(f1Var, "uuidGenerator");
        this.f13587a = context;
        final int i = 0;
        this.f13588b = new rd.j(new fe.a(this) { // from class: vc.b0

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ c0 f13579w;

            {
                this.f13579w = this;
            }

            @Override // fe.a
            public final Object b() {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        return ((d0) this.f13579w.f13591e.getValue()).f13598a;
                    default:
                        return t.b(this.f13579w.f13587a);
                }
            }
        });
        this.f13589c = Process.myPid();
        this.f13590d = new rd.j(new c.d0(9, f1Var));
        final int i10 = 1;
        this.f13591e = new rd.j(new fe.a(this) { // from class: vc.b0

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ c0 f13579w;

            {
                this.f13579w = this;
            }

            @Override // fe.a
            public final Object b() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        return ((d0) this.f13579w.f13591e.getValue()).f13598a;
                    default:
                        return t.b(this.f13579w.f13587a);
                }
            }
        });
    }

    public final String a() {
        return (String) this.f13588b.getValue();
    }

    public final Map b(Map map) {
        rd.j jVar = this.f13590d;
        if (map != null) {
            LinkedHashMap linkedHashMapD = sd.s.D(map);
            linkedHashMapD.put(a(), new a0(Process.myPid(), (String) jVar.getValue()));
            return sd.s.C(linkedHashMapD);
        }
        Map mapSingletonMap = Collections.singletonMap(a(), new a0(Process.myPid(), (String) jVar.getValue()));
        ge.i.d(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }
}
