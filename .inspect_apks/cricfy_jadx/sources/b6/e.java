package b6;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends android.support.v4.media.session.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1798e;

    public /* synthetic */ e(int i) {
        this.f1798e = i;
    }

    @Override // android.support.v4.media.session.b
    public final void b(c5.c cVar, Object obj) {
        switch (this.f1798e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) obj;
                cVar.e(1, gVar.f1804a);
                String str = gVar.f1805b;
                if (str == null) {
                    cVar.b(2);
                } else {
                    cVar.E(2, str);
                }
                String str2 = gVar.f1806c;
                if (str2 == null) {
                    cVar.b(3);
                } else {
                    cVar.E(3, str2);
                }
                String str3 = gVar.f1807d;
                if (str3 == null) {
                    cVar.b(4);
                } else {
                    cVar.E(4, str3);
                }
                String str4 = gVar.f1808e;
                if (str4 != null) {
                    cVar.E(5, str4);
                } else {
                    cVar.b(5);
                }
                break;
            case 1:
                i iVar = (i) obj;
                cVar.e(1, iVar.f1815a);
                String str5 = iVar.f1816b;
                if (str5 == null) {
                    cVar.b(2);
                } else {
                    cVar.E(2, str5);
                }
                String str6 = iVar.f1817c;
                if (str6 == null) {
                    cVar.b(3);
                } else {
                    cVar.E(3, str6);
                }
                String str7 = iVar.f1818d;
                if (str7 == null) {
                    cVar.b(4);
                } else {
                    cVar.E(4, str7);
                }
                String str8 = iVar.f1819e;
                if (str8 == null) {
                    cVar.b(5);
                } else {
                    cVar.E(5, str8);
                }
                String str9 = iVar.f;
                if (str9 == null) {
                    cVar.b(6);
                } else {
                    cVar.E(6, str9);
                }
                cVar.e(7, iVar.f1820g);
                cVar.e(8, iVar.f1821h);
                break;
            default:
                h hVar = (h) obj;
                cVar.e(1, hVar.f1809a);
                String str10 = hVar.f1810b;
                if (str10 == null) {
                    cVar.b(2);
                } else {
                    cVar.E(2, str10);
                }
                String str11 = hVar.f1811c;
                if (str11 == null) {
                    cVar.b(3);
                } else {
                    cVar.E(3, str11);
                }
                String str12 = hVar.f1812d;
                if (str12 == null) {
                    cVar.b(4);
                } else {
                    cVar.E(4, str12);
                }
                String str13 = hVar.f1813e;
                if (str13 == null) {
                    cVar.b(5);
                } else {
                    cVar.E(5, str13);
                }
                cVar.e(6, hVar.f ? 1L : 0L);
                cVar.e(7, hVar.f1814g);
                break;
        }
    }

    @Override // android.support.v4.media.session.b
    public final String h() {
        switch (this.f1798e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "INSERT OR REPLACE INTO `fav_channels` (`id`,`name`,`image`,`link`,`playlist`) VALUES (nullif(?, 0),?,?,?,?)";
            case 1:
                return "INSERT OR REPLACE INTO `ns_data` (`id`,`url`,`ref`,`origin`,`ua`,`license`,`drmType`,`advanceOptions`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
            default:
                return "INSERT OR ABORT INTO `notifications` (`id`,`title`,`body`,`image`,`url`,`opened`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
        }
    }
}
