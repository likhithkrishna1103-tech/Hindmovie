package b6;

import android.content.res.Resources;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import fe.l;
import java.util.ArrayList;
import pe.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1790v;

    public /* synthetic */ a(int i) {
        this.f1790v = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // fe.l
    public final Object a(Object obj) throws Exception {
        c5.c cVarC0;
        switch (this.f1790v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                cVarC0 = ((c5.a) obj).c0("SELECT * FROM notifications ORDER BY timestamp DESC");
                try {
                    int iK = com.bumptech.glide.c.k(cVarC0, "id");
                    int iK2 = com.bumptech.glide.c.k(cVarC0, "title");
                    int iK3 = com.bumptech.glide.c.k(cVarC0, "body");
                    int iK4 = com.bumptech.glide.c.k(cVarC0, "image");
                    int iK5 = com.bumptech.glide.c.k(cVarC0, "url");
                    int iK6 = com.bumptech.glide.c.k(cVarC0, "opened");
                    int iK7 = com.bumptech.glide.c.k(cVarC0, "timestamp");
                    ArrayList arrayList = new ArrayList();
                    while (cVarC0.V()) {
                        h hVar = new h(cVarC0.isNull(iK2) ? null : cVarC0.j(iK2), cVarC0.isNull(iK3) ? null : cVarC0.j(iK3), cVarC0.isNull(iK4) ? null : cVarC0.j(iK4), cVarC0.isNull(iK5) ? null : cVarC0.j(iK5), ((int) cVarC0.getLong(iK6)) != 0, cVarC0.getLong(iK7));
                        hVar.f1809a = (int) cVarC0.getLong(iK);
                        arrayList.add(hVar);
                        break;
                    }
                    return arrayList;
                } finally {
                }
            case 1:
                cVarC0 = ((c5.a) obj).c0("SELECT * FROM fav_channels");
                try {
                    int iK8 = com.bumptech.glide.c.k(cVarC0, "id");
                    int iK9 = com.bumptech.glide.c.k(cVarC0, "name");
                    int iK10 = com.bumptech.glide.c.k(cVarC0, "image");
                    int iK11 = com.bumptech.glide.c.k(cVarC0, "link");
                    int iK12 = com.bumptech.glide.c.k(cVarC0, "playlist");
                    ArrayList arrayList2 = new ArrayList();
                    while (cVarC0.V()) {
                        String strJ = null;
                        String strJ2 = cVarC0.isNull(iK9) ? null : cVarC0.j(iK9);
                        String strJ3 = cVarC0.isNull(iK10) ? null : cVarC0.j(iK10);
                        String strJ4 = cVarC0.isNull(iK11) ? null : cVarC0.j(iK11);
                        if (!cVarC0.isNull(iK12)) {
                            strJ = cVarC0.j(iK12);
                        }
                        g gVar = new g(strJ2, strJ3, strJ4, strJ);
                        gVar.f1804a = (int) cVarC0.getLong(iK8);
                        arrayList2.add(gVar);
                        break;
                    }
                    return arrayList2;
                } finally {
                }
            case 2:
                cVarC0 = ((c5.a) obj).c0("DELETE FROM notifications");
                try {
                    cVarC0.V();
                    cVarC0.close();
                    return null;
                } finally {
                }
            case 3:
                cVarC0 = ((c5.a) obj).c0("SELECT * FROM ns_data WHERE id = 1 LIMIT 1");
                try {
                    int iK13 = com.bumptech.glide.c.k(cVarC0, "id");
                    int iK14 = com.bumptech.glide.c.k(cVarC0, "url");
                    int iK15 = com.bumptech.glide.c.k(cVarC0, "ref");
                    int iK16 = com.bumptech.glide.c.k(cVarC0, "origin");
                    int iK17 = com.bumptech.glide.c.k(cVarC0, "ua");
                    int iK18 = com.bumptech.glide.c.k(cVarC0, "license");
                    int iK19 = com.bumptech.glide.c.k(cVarC0, "drmType");
                    int iK20 = com.bumptech.glide.c.k(cVarC0, "advanceOptions");
                    if (cVarC0.V()) {
                        i iVar = new i(cVarC0.isNull(iK14) ? null : cVarC0.j(iK14), cVarC0.isNull(iK15) ? null : cVarC0.j(iK15), cVarC0.isNull(iK16) ? null : cVarC0.j(iK16), cVarC0.isNull(iK17) ? null : cVarC0.j(iK17), cVarC0.isNull(iK18) ? null : cVarC0.j(iK18), (int) cVarC0.getLong(iK19), (int) cVarC0.getLong(iK20));
                        iVar.f1815a = (int) cVarC0.getLong(iK13);
                        obj = iVar;
                    }
                    return obj;
                } finally {
                }
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                Resources resources = (Resources) obj;
                ge.i.e(resources, "resources");
                return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                vd.f fVar = (vd.f) obj;
                if (fVar instanceof s) {
                    return (s) fVar;
                }
                return null;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                d1.c cVar = (d1.c) obj;
                ge.i.e(cVar, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session configs DataStore", cVar);
                return yc.h.f15040b;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                c5.c cVar2 = (c5.c) obj;
                ge.i.e(cVar2, "it");
                return Boolean.valueOf(cVar2.V());
            default:
                c5.c cVar3 = (c5.c) obj;
                ge.i.e(cVar3, "statement");
                td.i iVar2 = new td.i();
                while (cVar3.V()) {
                    iVar2.add(Integer.valueOf((int) cVar3.getLong(0)));
                }
                return u8.a.d(iVar2);
        }
    }
}
