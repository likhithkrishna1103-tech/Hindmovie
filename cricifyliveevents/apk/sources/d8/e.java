package d8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.SparseBooleanArray;
import androidx.emoji2.text.v;
import androidx.fragment.app.f1;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;
import java.util.Objects;
import k4.b0;
import k4.l0;
import k4.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3532v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3533w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3534x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f3535y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f3536z;

    public /* synthetic */ e(cd.e eVar, dd.e eVar2, List list, int i) {
        this.f3534x = eVar;
        this.f3535y = eVar2;
        this.f3536z = list;
        this.f3533w = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3532v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j jVar = (j) this.f3534x;
                x7.i iVar = (x7.i) this.f3535y;
                int i = this.f3533w;
                Runnable runnable = (Runnable) this.f3536z;
                f8.c cVar = (f8.c) jVar.f;
                try {
                    try {
                        e8.d dVar = (e8.d) jVar.f3553c;
                        Objects.requireNonNull(dVar);
                        ((e8.i) cVar).A(new f1(4, dVar));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ((Context) jVar.f3551a).getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            ((e8.i) cVar).A(new f(i, jVar, iVar));
                        } else {
                            jVar.e(iVar, i);
                        }
                        break;
                    } catch (f8.a unused) {
                        ((v) jVar.f3554d).C(iVar, i + 1, false);
                    }
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    runnable.run();
                    throw th;
                }
            case 1:
                ((cd.e) this.f3534x).d((dd.e) this.f3535y, (List) this.f3536z, this.f3533w);
                return;
            default:
                f3.a aVar = (f3.a) this.f3534x;
                List list = (List) this.f3535y;
                s sVar = (s) this.f3536z;
                b0 b0Var = ((l0) aVar.f3937y).f7060g;
                int i10 = this.f3533w;
                if (i10 == -1) {
                    b0Var.f6924t.t0(list);
                } else {
                    b0Var.f6924t.t(i10, list);
                }
                new SparseBooleanArray().append(20, true);
                b0Var.p(sVar);
                return;
        }
    }

    public /* synthetic */ e(j jVar, x7.i iVar, int i, Runnable runnable) {
        this.f3534x = jVar;
        this.f3535y = iVar;
        this.f3533w = i;
        this.f3536z = runnable;
    }

    public /* synthetic */ e(f3.a aVar, int i, List list, s sVar) {
        this.f3534x = aVar;
        this.f3533w = i;
        this.f3535y = list;
        this.f3536z = sVar;
    }
}
