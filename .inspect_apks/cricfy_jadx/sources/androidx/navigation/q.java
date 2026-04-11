package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadLocal f1391c = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f1393b;

    public static y a(TypedValue typedValue, y yVar, y yVar2, String str, String str2) throws XmlPullParserException {
        if (yVar == null || yVar == yVar2) {
            return yVar != null ? yVar : yVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.navigation.d d(android.content.res.TypedArray r26, android.content.res.Resources r27, int r28) throws org.xmlpull.v1.XmlPullParserException {
        /*
            Method dump skipped, instruction units count: 955
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.q.d(android.content.res.TypedArray, android.content.res.Resources, int):androidx.navigation.d");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0224, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.navigation.l b(android.content.res.Resources r18, android.content.res.XmlResourceParser r19, android.util.AttributeSet r20, int r21) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.q.b(android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, int):androidx.navigation.l");
    }

    public final n c(int i) {
        int next;
        Resources resources = this.f1392a.getResources();
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e9) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e9);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        l lVarB = b(resources, xml, attributeSetAsAttributeSet, i);
        if (lVarB instanceof n) {
            return (n) lVarB;
        }
        throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
    }
}
