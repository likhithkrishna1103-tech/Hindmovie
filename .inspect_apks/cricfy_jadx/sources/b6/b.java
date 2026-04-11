package b6;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1791v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f1792w;

    public /* synthetic */ b(int i, String str) {
        this.f1791v = i;
        this.f1792w = str;
    }

    @Override // fe.l
    public final Object a(Object obj) throws Exception {
        switch (this.f1791v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c5.c cVarC0 = ((c5.a) obj).c0("SELECT * FROM fav_channels WHERE name = ? LIMIT 1");
                String str = this.f1792w;
                try {
                    if (str == null) {
                        cVarC0.b(1);
                    } else {
                        cVarC0.E(1, str);
                    }
                    int iK = com.bumptech.glide.c.k(cVarC0, "id");
                    int iK2 = com.bumptech.glide.c.k(cVarC0, "name");
                    int iK3 = com.bumptech.glide.c.k(cVarC0, "image");
                    int iK4 = com.bumptech.glide.c.k(cVarC0, "link");
                    int iK5 = com.bumptech.glide.c.k(cVarC0, "playlist");
                    g gVar = null;
                    String strJ = null;
                    if (cVarC0.V()) {
                        String strJ2 = cVarC0.isNull(iK2) ? null : cVarC0.j(iK2);
                        String strJ3 = cVarC0.isNull(iK3) ? null : cVarC0.j(iK3);
                        String strJ4 = cVarC0.isNull(iK4) ? null : cVarC0.j(iK4);
                        if (!cVarC0.isNull(iK5)) {
                            strJ = cVarC0.j(iK5);
                        }
                        g gVar2 = new g(strJ2, strJ3, strJ4, strJ);
                        gVar2.f1804a = (int) cVarC0.getLong(iK);
                        gVar = gVar2;
                    }
                    cVarC0.close();
                    return gVar;
                } catch (Throwable th) {
                    cVarC0.close();
                    throw th;
                }
            default:
                String str2 = (String) obj;
                ge.i.e(str2, "it");
                boolean zK0 = ne.h.k0(str2);
                String str3 = this.f1792w;
                return zK0 ? str2.length() < str3.length() ? str3 : str2 : str3.concat(str2);
        }
    }
}
