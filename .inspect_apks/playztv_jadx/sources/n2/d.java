package n2;

import android.util.Base64;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import q3.q;
import q3.s;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends k8.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8662e;
    public UUID f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f8663g;

    @Override // k8.c
    public final Object b() {
        UUID uuid = this.f;
        byte[] bArrA = q.a(uuid, null, this.f8663g);
        byte[] bArr = this.f8663g;
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < bArr.length; i += 2) {
            sb2.append((char) bArr[i]);
        }
        String string = sb2.toString();
        byte[] bArrDecode = Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
        byte b10 = bArrDecode[0];
        bArrDecode[0] = bArrDecode[3];
        bArrDecode[3] = b10;
        byte b11 = bArrDecode[1];
        bArrDecode[1] = bArrDecode[2];
        bArrDecode[2] = b11;
        byte b12 = bArrDecode[4];
        bArrDecode[4] = bArrDecode[5];
        bArrDecode[5] = b12;
        byte b13 = bArrDecode[6];
        bArrDecode[6] = bArrDecode[7];
        bArrDecode[7] = b13;
        return new a(uuid, bArrA, new s[]{new s(true, null, 8, bArrDecode, 0, 0, null)});
    }

    @Override // k8.c
    public final boolean d(String str) {
        return "ProtectionHeader".equals(str);
    }

    @Override // k8.c
    public final void f(XmlPullParser xmlPullParser) {
        if ("ProtectionHeader".equals(xmlPullParser.getName())) {
            this.f8662e = false;
        }
    }

    @Override // k8.c
    public final void j(XmlPullParser xmlPullParser) {
        if ("ProtectionHeader".equals(xmlPullParser.getName())) {
            this.f8662e = true;
            String attributeValue = xmlPullParser.getAttributeValue(null, "SystemID");
            if (attributeValue.charAt(0) == '{' && attributeValue.charAt(attributeValue.length() - 1) == '}') {
                attributeValue = attributeValue.substring(1, attributeValue.length() - 1);
            }
            this.f = UUID.fromString(attributeValue);
        }
    }

    @Override // k8.c
    public final void k(XmlPullParser xmlPullParser) {
        if (this.f8662e) {
            this.f8663g = Base64.decode(xmlPullParser.getText(), 0);
        }
    }
}
