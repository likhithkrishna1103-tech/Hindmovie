package n2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import p1.m0;
import p1.p;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends k8.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f8664e;

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList s(java.lang.String r11) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            if (r1 != 0) goto Lbf
            int r1 = s1.b0.f11647a
            int r1 = r11.length()
            int r1 = r1 / 2
            byte[] r2 = new byte[r1]
            r3 = 0
            r4 = r3
        L17:
            r5 = 4
            if (r4 >= r1) goto L39
            int r6 = r4 * 2
            char r7 = r11.charAt(r6)
            r8 = 16
            int r7 = java.lang.Character.digit(r7, r8)
            int r5 = r7 << 4
            int r6 = r6 + 1
            char r6 = r11.charAt(r6)
            int r6 = java.lang.Character.digit(r6, r8)
            int r6 = r6 + r5
            byte r5 = (byte) r6
            r2[r4] = r5
            int r4 = r4 + 1
            goto L17
        L39:
            byte[] r11 = s1.e.f11662a
            if (r1 > r5) goto L3e
            goto L49
        L3e:
            r11 = r3
        L3f:
            byte[] r4 = s1.e.f11662a
            if (r11 >= r5) goto L4f
            r6 = r2[r11]
            r4 = r4[r11]
            if (r6 == r4) goto L4c
        L49:
            r11 = 0
            goto Lb6
        L4c:
            int r11 = r11 + 1
            goto L3f
        L4f:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r4 = r3
        L55:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r11.add(r6)
            int r4 = r4 + r5
            int r6 = r1 + (-4)
        L5f:
            r7 = -1
            if (r4 > r6) goto L7a
            int r8 = r1 - r4
            if (r8 > r5) goto L67
            goto L74
        L67:
            r8 = r3
        L68:
            byte[] r9 = s1.e.f11662a
            if (r8 >= r5) goto L7b
            int r10 = r4 + r8
            r10 = r2[r10]
            r9 = r9[r8]
            if (r10 == r9) goto L77
        L74:
            int r4 = r4 + 1
            goto L5f
        L77:
            int r8 = r8 + 1
            goto L68
        L7a:
            r4 = r7
        L7b:
            if (r4 != r7) goto L55
            int r4 = r11.size()
            byte[][] r4 = new byte[r4][]
            r5 = r3
        L84:
            int r6 = r11.size()
            if (r5 >= r6) goto Lb5
            java.lang.Object r6 = r11.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            int r7 = r11.size()
            int r7 = r7 + (-1)
            if (r5 >= r7) goto La9
            int r7 = r5 + 1
            java.lang.Object r7 = r11.get(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            goto Laa
        La9:
            r7 = r1
        Laa:
            int r7 = r7 - r6
            byte[] r8 = new byte[r7]
            java.lang.System.arraycopy(r2, r6, r8, r3, r7)
            r4[r5] = r8
            int r5 = r5 + 1
            goto L84
        Lb5:
            r11 = r4
        Lb6:
            if (r11 != 0) goto Lbc
            r0.add(r2)
            return r0
        Lbc:
            java.util.Collections.addAll(r0, r11)
        Lbf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.e.s(java.lang.String):java.util.ArrayList");
    }

    @Override // k8.c
    public final Object b() {
        return this.f8664e;
    }

    @Override // k8.c
    public final void j(XmlPullParser xmlPullParser) throws c3.d {
        p pVar = new p();
        String attributeValue = xmlPullParser.getAttributeValue(null, "FourCC");
        if (attributeValue == null) {
            throw new c3.d("FourCC", 1);
        }
        String str = (attributeValue.equalsIgnoreCase("H264") || attributeValue.equalsIgnoreCase("X264") || attributeValue.equalsIgnoreCase("AVC1") || attributeValue.equalsIgnoreCase("DAVC")) ? "video/avc" : (attributeValue.equalsIgnoreCase("AAC") || attributeValue.equalsIgnoreCase("AACL") || attributeValue.equalsIgnoreCase("AACH") || attributeValue.equalsIgnoreCase("AACP")) ? "audio/mp4a-latm" : (attributeValue.equalsIgnoreCase("TTML") || attributeValue.equalsIgnoreCase("DFXP")) ? "application/ttml+xml" : (attributeValue.equalsIgnoreCase("ac-3") || attributeValue.equalsIgnoreCase("dac3")) ? "audio/ac3" : (attributeValue.equalsIgnoreCase("ec-3") || attributeValue.equalsIgnoreCase("dec3")) ? "audio/eac3" : attributeValue.equalsIgnoreCase("dtsc") ? "audio/vnd.dts" : (attributeValue.equalsIgnoreCase("dtsh") || attributeValue.equalsIgnoreCase("dtsl")) ? "audio/vnd.dts.hd" : attributeValue.equalsIgnoreCase("dtse") ? "audio/vnd.dts.hd;profile=lbr" : attributeValue.equalsIgnoreCase("opus") ? "audio/opus" : null;
        int iIntValue = ((Integer) c("Type")).intValue();
        if (iIntValue == 2) {
            ArrayList arrayListS = s(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
            pVar.f9966l = m0.p("video/mp4");
            pVar.f9974t = k8.c.i(xmlPullParser, "MaxWidth");
            pVar.f9975u = k8.c.i(xmlPullParser, "MaxHeight");
            pVar.f9970p = arrayListS;
        } else {
            int i = 0;
            if (iIntValue == 1) {
                if (str == null) {
                    str = "audio/mp4a-latm";
                }
                int i10 = k8.c.i(xmlPullParser, "Channels");
                int i11 = k8.c.i(xmlPullParser, "SamplingRate");
                ArrayList arrayListS2 = s(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                boolean zIsEmpty = arrayListS2.isEmpty();
                List listSingletonList = arrayListS2;
                if (zIsEmpty) {
                    listSingletonList = arrayListS2;
                    if ("audio/mp4a-latm".equals(str)) {
                        int i12 = -1;
                        int i13 = 0;
                        while (true) {
                            int[] iArr = w2.b.f13571a;
                            if (i13 >= 13) {
                                break;
                            }
                            if (i11 == iArr[i13]) {
                                i12 = i13;
                            }
                            i13++;
                        }
                        int i14 = -1;
                        while (true) {
                            int[] iArr2 = w2.b.f13572b;
                            if (i >= 16) {
                                break;
                            }
                            if (i10 == iArr2[i]) {
                                i14 = i;
                            }
                            i++;
                        }
                        if (i11 == -1 || i14 == -1) {
                            throw new IllegalArgumentException(l4.a.l(i11, i10, "Invalid sample rate or number of channels: ", ", "));
                        }
                        listSingletonList = Collections.singletonList(w2.b.a(2, i12, i14));
                    }
                }
                pVar.f9966l = m0.p("audio/mp4");
                pVar.E = i10;
                pVar.F = i11;
                pVar.f9970p = listSingletonList;
            } else if (iIntValue == 3) {
                String str2 = (String) c("Subtype");
                if (str2 != null) {
                    if (str2.equals("CAPT")) {
                        i = 64;
                    } else if (str2.equals("DESC")) {
                        i = 1024;
                    }
                }
                pVar.f9966l = m0.p("application/mp4");
                pVar.f = i;
            } else {
                pVar.f9966l = m0.p("application/mp4");
            }
        }
        pVar.f9957a = xmlPullParser.getAttributeValue(null, "Index");
        pVar.f9958b = (String) c("Name");
        pVar.f9967m = m0.p(str);
        pVar.f9963h = k8.c.i(xmlPullParser, "Bitrate");
        pVar.f9960d = (String) c("Language");
        this.f8664e = new q(pVar);
    }
}
