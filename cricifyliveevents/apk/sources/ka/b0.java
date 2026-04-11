package ka;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f7287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[][] f7288c = new int[10][];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d[] f7289d = new d[10];

    public static b0 b(d dVar) {
        b0 b0Var = new b0();
        b0Var.a(StateSet.WILD_CARD, dVar);
        return b0Var;
    }

    public final void a(int[] iArr, d dVar) {
        int i = this.f7286a;
        if (i == 0 || iArr.length == 0) {
            this.f7287b = dVar;
        }
        int[][] iArr2 = this.f7288c;
        if (i >= iArr2.length) {
            int i10 = i + 10;
            int[][] iArr3 = new int[i10][];
            System.arraycopy(iArr2, 0, iArr3, 0, i);
            this.f7288c = iArr3;
            d[] dVarArr = new d[i10];
            System.arraycopy(this.f7289d, 0, dVarArr, 0, i);
            this.f7289d = dVarArr;
        }
        int[][] iArr4 = this.f7288c;
        int i11 = this.f7286a;
        iArr4[i11] = iArr;
        this.f7289d[i11] = dVar;
        this.f7286a = i11 + 1;
    }

    public final d c(int[] iArr) {
        int i;
        int[][] iArr2 = this.f7288c;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i = -1;
            if (i11 >= this.f7286a) {
                i11 = -1;
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                break;
            }
            i11++;
        }
        if (i11 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = this.f7288c;
            while (true) {
                if (i10 >= this.f7286a) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i10], iArr3)) {
                    i = i10;
                    break;
                }
                i10++;
            }
            i11 = i;
        }
        return i11 < 0 ? this.f7287b : this.f7289d[i11];
    }

    public final void d(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, k9.l.ShapeAppearance) : theme.obtainStyledAttributes(attributeSet, k9.l.ShapeAppearance, 0, 0);
                d dVarD = m.d(typedArrayObtainAttributes, k9.l.ShapeAppearance_cornerSize, new a(0.0f));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i = 0;
                for (int i10 = 0; i10 < attributeCount; i10++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i10);
                    if (attributeNameResource != k9.b.cornerSize) {
                        int i11 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i10, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i] = attributeNameResource;
                        i = i11;
                    }
                }
                a(StateSet.trimStateSet(iArr, i), dVarD);
            }
        }
    }
}
