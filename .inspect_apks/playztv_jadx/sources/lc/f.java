package lc;

import a2.g0;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Executors;
import r4.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ nc.c A;
    public final /* synthetic */ Object B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8088u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ rc.c f8089v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ rc.b f8090w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ String f8091x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ oc.c f8092y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ String f8093z;

    public /* synthetic */ f(Context context, rc.c cVar, String str, rc.b bVar, oc.c cVar2, String str2, nc.c cVar3) {
        this.B = context;
        this.f8089v = cVar;
        this.f8091x = str;
        this.f8090w = bVar;
        this.f8092y = cVar2;
        this.f8093z = str2;
        this.A = cVar3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8088u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h.f fVar = new h.f((Context) this.B);
                final rc.c cVar = this.f8089v;
                final String str = this.f8091x;
                h.c cVar2 = fVar.f5489a;
                if (cVar == null) {
                    fVar.setTitle("Add Favourites");
                    cVar2.f = "Are you sure, you want to add " + str + " to favourites?";
                    fVar.a("Add", null);
                } else {
                    fVar.setTitle("Delete Favourites");
                    cVar2.f = "Are you sure, you want to delete " + str + " from favourites?";
                    fVar.a("Delete", null);
                }
                cVar2.i = "Cancel";
                cVar2.f5447j = null;
                final h.g gVarB = fVar.b();
                Button button = gVarB.A.i;
                final rc.b bVar = this.f8090w;
                final oc.c cVar3 = this.f8092y;
                final String str2 = this.f8093z;
                final nc.c cVar4 = this.A;
                button.setOnClickListener(new View.OnClickListener() { // from class: lc.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Executors.newSingleThreadExecutor().execute(new f(cVar, bVar, str, cVar3, str2, cVar4, gVarB));
                    }
                });
                break;
            default:
                rc.b bVar2 = this.f8090w;
                t tVar = (t) bVar2.f11562v;
                h.g gVar = (h.g) this.B;
                rc.c cVar5 = this.f8089v;
                oc.c cVar6 = this.f8092y;
                nc.c cVar7 = this.A;
                if (cVar5 == null) {
                    String str3 = cVar6.f9516b;
                    String str4 = cVar6.f9517c;
                    String str5 = this.f8093z;
                    if (str5 == null) {
                        str5 = "";
                    }
                    z7.a.v(tVar, false, true, new he.i(bVar2, new rc.c(this.f8091x, str3, str4, str5)));
                    if (cVar7 != null) {
                        new Handler(Looper.getMainLooper()).post(new g0(cVar7, true, cVar6));
                    }
                } else {
                    final int i = cVar5.f11563a;
                    z7.a.v(tVar, false, true, new ae.l() { // from class: rc.a
                        @Override // ae.l
                        public final Object a(Object obj) throws Exception {
                            int i10 = i;
                            y4.c cVarE0 = ((y4.a) obj).e0("DELETE FROM fav_channels WHERE id = ?");
                            try {
                                cVarE0.k(i10);
                                cVarE0.W();
                                cVarE0.close();
                                return null;
                            } catch (Throwable th) {
                                cVarE0.close();
                                throw th;
                            }
                        }
                    });
                    if (cVar7 != null) {
                        new Handler(Looper.getMainLooper()).post(new g0(cVar7, false, cVar6));
                    }
                }
                gVar.dismiss();
                break;
        }
    }

    public /* synthetic */ f(rc.c cVar, rc.b bVar, String str, oc.c cVar2, String str2, nc.c cVar3, h.g gVar) {
        this.f8089v = cVar;
        this.f8090w = bVar;
        this.f8091x = str;
        this.f8092y = cVar2;
        this.f8093z = str2;
        this.A = cVar3;
        this.B = gVar;
    }
}
