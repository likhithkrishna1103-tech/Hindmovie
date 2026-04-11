package l6;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements c6.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f7955c;

    public /* synthetic */ a(Object obj, int i, Object obj2) {
        this.f7953a = i;
        this.f7954b = obj;
        this.f7955c = obj2;
    }

    @Override // c6.k
    public final boolean a(Object obj, c6.i iVar) {
        switch (this.f7953a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((c6.k) this.f7954b).a(obj, iVar);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                ((o) this.f7954b).getClass();
                return true;
        }
    }

    @Override // c6.k
    public final e6.b0 b(Object obj, int i, int i10, c6.i iVar) {
        boolean z2;
        v vVar;
        x6.e eVar;
        switch (this.f7953a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e6.b0 b0VarB = ((c6.k) this.f7954b).b(obj, i, i10, iVar);
                Resources resources = (Resources) this.f7955c;
                if (b0VarB == null) {
                    return null;
                }
                return new d(resources, b0VarB);
            case 1:
                e6.b0 b0VarC = ((n6.c) this.f7954b).c((Uri) obj, iVar);
                if (b0VarC == null) {
                    return null;
                }
                return q.a((f6.a) this.f7955c, (Drawable) ((n6.b) b0VarC).get(), i, i10);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof v) {
                    vVar = (v) inputStream;
                    z2 = false;
                } else {
                    z2 = true;
                    vVar = new v(inputStream, (f6.f) this.f7955c);
                }
                ArrayDeque arrayDeque = x6.e.f14277w;
                synchronized (arrayDeque) {
                    eVar = (x6.e) arrayDeque.poll();
                    break;
                }
                if (eVar == null) {
                    eVar = new x6.e();
                }
                x6.e eVar2 = eVar;
                eVar2.f14278u = vVar;
                x6.j jVar = new x6.j(eVar2);
                k4 k4Var = new k4(vVar, eVar2);
                try {
                    o oVar = (o) this.f7954b;
                    d dVarA = oVar.a(new kc.b(jVar, oVar.f7995d, oVar.f7994c), i, i10, iVar, k4Var);
                    eVar2.a();
                    if (z2) {
                        vVar.d();
                    }
                    return dVarA;
                } finally {
                }
        }
    }

    public a(Resources resources, c6.k kVar) {
        this.f7953a = 0;
        this.f7955c = resources;
        this.f7954b = kVar;
    }
}
