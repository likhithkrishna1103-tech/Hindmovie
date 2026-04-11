package ka;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f7299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[][] f7300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m[] f7301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b0 f7302e;
    public final b0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b0 f7303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b0 f7304h;

    public d0(c0 c0Var) {
        this.f7298a = c0Var.f7292b;
        this.f7299b = (m) c0Var.f7293c;
        this.f7300c = (int[][]) c0Var.f7294d;
        this.f7301d = (m[]) c0Var.f7295e;
        this.f7302e = (b0) c0Var.f;
        this.f = (b0) c0Var.f7296g;
        this.f7303g = (b0) c0Var.f7297h;
        this.f7304h = (b0) c0Var.i;
    }

    public static void a(c0 c0Var, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, k9.l.MaterialShape) : theme.obtainStyledAttributes(attributeSet, k9.l.MaterialShape, 0, 0);
                m mVarA = m.a(context, typedArrayObtainAttributes.getResourceId(k9.l.MaterialShape_shapeAppearance, 0), typedArrayObtainAttributes.getResourceId(k9.l.MaterialShape_shapeAppearanceOverlay, 0)).a();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i = 0;
                for (int i10 = 0; i10 < attributeCount; i10++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i10);
                    if (attributeNameResource != k9.b.shapeAppearance && attributeNameResource != k9.b.shapeAppearanceOverlay) {
                        int i11 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i10, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i] = attributeNameResource;
                        i = i11;
                    }
                }
                c0Var.a(StateSet.trimStateSet(iArr, i), mVarA);
            }
        }
    }

    public static d0 b(Context context, TypedArray typedArray, int i) {
        XmlResourceParser xml;
        AttributeSet attributeSetAsAttributeSet;
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        c0 c0Var = new c0(0);
        c0Var.d();
        try {
            xml = context.getResources().getXml(resourceId);
            try {
                attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
            } catch (Throwable th) {
                if (xml != null) {
                    try {
                        xml.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            c0Var.d();
        }
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (xml.getName().equals("selector")) {
            a(c0Var, context, xml, attributeSetAsAttributeSet, context.getTheme());
        }
        xml.close();
        if (c0Var.f7292b == 0) {
            return null;
        }
        return new d0(c0Var);
    }

    public final m c() {
        m mVar = this.f7299b;
        b0 b0Var = this.f7304h;
        b0 b0Var2 = this.f7303g;
        b0 b0Var3 = this.f;
        b0 b0Var4 = this.f7302e;
        if (b0Var4 == null && b0Var3 == null && b0Var2 == null && b0Var == null) {
            return mVar;
        }
        l lVarG = mVar.g();
        if (b0Var4 != null) {
            lVarG.f7343e = b0Var4.f7287b;
        }
        if (b0Var3 != null) {
            lVarG.f = b0Var3.f7287b;
        }
        if (b0Var2 != null) {
            lVarG.f7345h = b0Var2.f7287b;
        }
        if (b0Var != null) {
            lVarG.f7344g = b0Var.f7287b;
        }
        return lVarG.a();
    }

    public final boolean d() {
        b0 b0Var;
        b0 b0Var2;
        b0 b0Var3;
        b0 b0Var4;
        return this.f7298a > 1 || ((b0Var = this.f7302e) != null && b0Var.f7286a > 1) || (((b0Var2 = this.f) != null && b0Var2.f7286a > 1) || (((b0Var3 = this.f7303g) != null && b0Var3.f7286a > 1) || ((b0Var4 = this.f7304h) != null && b0Var4.f7286a > 1)));
    }
}
