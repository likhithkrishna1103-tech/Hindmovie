package v5;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.room.db.AppDatabase;
import java.util.concurrent.Executors;
import w4.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ String A;
    public final /* synthetic */ Object B;
    public final /* synthetic */ Object C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13417v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f13418w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f13419x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ String f13420y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f13421z;

    public /* synthetic */ e(Context context, b6.g gVar, String str, b6.f fVar, y5.c cVar, String str2, kb.d dVar) {
        this.C = context;
        this.f13418w = gVar;
        this.f13420y = str;
        this.f13419x = fVar;
        this.f13421z = cVar;
        this.A = str2;
        this.B = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f13417v;
        Object obj = this.B;
        Object obj2 = this.f13421z;
        Object obj3 = this.f13419x;
        Object obj4 = this.f13418w;
        Object obj5 = this.C;
        boolean z10 = true;
        boolean z11 = false;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                final b6.g gVar = (b6.g) obj4;
                final b6.f fVar = (b6.f) obj3;
                final y5.c cVar = (y5.c) obj2;
                final kb.d dVar = (kb.d) obj;
                x9.b bVar = new x9.b((Context) obj5, 0);
                final String str = this.f13420y;
                h.c cVar2 = bVar.f5346a;
                if (gVar == null) {
                    bVar.g("Add Favourites");
                    cVar2.f = "Are you sure, you want to add " + str + " to favourites?";
                    bVar.f("Add", null);
                } else {
                    bVar.g("Delete Favourites");
                    cVar2.f = "Are you sure, you want to delete " + str + " from favourites?";
                    bVar.f("Delete", null);
                }
                bVar.e();
                final h.h hVarD = bVar.d();
                Button button = hVarD.B.i;
                final String str2 = this.A;
                button.setOnClickListener(new View.OnClickListener() { // from class: v5.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Executors.newSingleThreadExecutor().execute(new e(gVar, fVar, str, cVar, str2, dVar, hVarD));
                    }
                });
                break;
            case 1:
                b6.g gVar2 = (b6.g) obj4;
                b6.f fVar2 = (b6.f) obj3;
                t tVar = (t) fVar2.f1800w;
                y5.c cVar3 = (y5.c) obj2;
                kb.d dVar2 = (kb.d) obj;
                h.h hVar = (h.h) obj5;
                if (gVar2 == null) {
                    String str3 = cVar3.f14914b;
                    String str4 = cVar3.f14915c;
                    String str5 = this.A;
                    if (str5 == null) {
                        str5 = "";
                    }
                    ab.b.s(tVar, false, true, new b6.c(2, fVar2, new b6.g(this.f13420y, str3, str4, str5)));
                    if (dVar2 != null) {
                        new Handler(Looper.getMainLooper()).post(new nc.i(dVar2, z10, cVar3));
                    }
                } else {
                    ab.b.s(tVar, false, true, new b6.d(gVar2.f1804a, 1));
                    if (dVar2 != null) {
                        new Handler(Looper.getMainLooper()).post(new nc.i(dVar2, z11, cVar3));
                    }
                }
                hVar.dismiss();
                break;
            default:
                m mVar = (m) obj5;
                String str6 = (String) obj4;
                String str7 = (String) obj3;
                String str8 = (String) obj2;
                b6.f fVarQ = AppDatabase.r(mVar.getContext()).q();
                String lowerCase = ((String) obj).toLowerCase();
                lowerCase.getClass();
                ab.b.s((t) fVarQ.f1800w, false, true, new b6.c(0, fVarQ, new b6.i(this.f13420y, this.A, str6, str7, str8, !lowerCase.equals("widevine") ? !lowerCase.equals("clearkey") ? 2 : 0 : 1, mVar.C.f12220a.isChecked() ? 1 : 0)));
                break;
        }
    }

    public /* synthetic */ e(b6.g gVar, b6.f fVar, String str, y5.c cVar, String str2, kb.d dVar, h.h hVar) {
        this.f13418w = gVar;
        this.f13419x = fVar;
        this.f13420y = str;
        this.f13421z = cVar;
        this.A = str2;
        this.B = dVar;
        this.C = hVar;
    }

    public /* synthetic */ e(m mVar, String str, String str2, String str3, String str4, String str5, String str6) {
        this.C = mVar;
        this.f13420y = str;
        this.A = str2;
        this.f13418w = str3;
        this.f13419x = str4;
        this.f13421z = str5;
        this.B = str6;
    }
}
