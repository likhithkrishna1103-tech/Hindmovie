package a0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f145d = {0, 4, 8};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f146e;
    public static final SparseIntArray f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f147a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f148b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f149c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f146e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f = sparseIntArray2;
        sparseIntArray.append(s.Constraint_layout_constraintLeft_toLeftOf, 25);
        sparseIntArray.append(s.Constraint_layout_constraintLeft_toRightOf, 26);
        sparseIntArray.append(s.Constraint_layout_constraintRight_toLeftOf, 29);
        sparseIntArray.append(s.Constraint_layout_constraintRight_toRightOf, 30);
        sparseIntArray.append(s.Constraint_layout_constraintTop_toTopOf, 36);
        sparseIntArray.append(s.Constraint_layout_constraintTop_toBottomOf, 35);
        sparseIntArray.append(s.Constraint_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(s.Constraint_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(s.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(s.Constraint_layout_constraintBaseline_toTopOf, 91);
        sparseIntArray.append(s.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sparseIntArray.append(s.Constraint_layout_editor_absoluteX, 6);
        sparseIntArray.append(s.Constraint_layout_editor_absoluteY, 7);
        sparseIntArray.append(s.Constraint_layout_constraintGuide_begin, 17);
        sparseIntArray.append(s.Constraint_layout_constraintGuide_end, 18);
        sparseIntArray.append(s.Constraint_layout_constraintGuide_percent, 19);
        sparseIntArray.append(s.Constraint_guidelineUseRtl, 99);
        sparseIntArray.append(s.Constraint_android_orientation, 27);
        sparseIntArray.append(s.Constraint_layout_constraintStart_toEndOf, 32);
        sparseIntArray.append(s.Constraint_layout_constraintStart_toStartOf, 33);
        sparseIntArray.append(s.Constraint_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(s.Constraint_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(s.Constraint_layout_goneMarginLeft, 13);
        sparseIntArray.append(s.Constraint_layout_goneMarginTop, 16);
        sparseIntArray.append(s.Constraint_layout_goneMarginRight, 14);
        sparseIntArray.append(s.Constraint_layout_goneMarginBottom, 11);
        sparseIntArray.append(s.Constraint_layout_goneMarginStart, 15);
        sparseIntArray.append(s.Constraint_layout_goneMarginEnd, 12);
        sparseIntArray.append(s.Constraint_layout_constraintVertical_weight, 40);
        sparseIntArray.append(s.Constraint_layout_constraintHorizontal_weight, 39);
        sparseIntArray.append(s.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray.append(s.Constraint_layout_constraintVertical_chainStyle, 42);
        sparseIntArray.append(s.Constraint_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(s.Constraint_layout_constraintVertical_bias, 37);
        sparseIntArray.append(s.Constraint_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(s.Constraint_layout_constraintLeft_creator, 87);
        sparseIntArray.append(s.Constraint_layout_constraintTop_creator, 87);
        sparseIntArray.append(s.Constraint_layout_constraintRight_creator, 87);
        sparseIntArray.append(s.Constraint_layout_constraintBottom_creator, 87);
        sparseIntArray.append(s.Constraint_layout_constraintBaseline_creator, 87);
        sparseIntArray.append(s.Constraint_android_layout_marginLeft, 24);
        sparseIntArray.append(s.Constraint_android_layout_marginRight, 28);
        sparseIntArray.append(s.Constraint_android_layout_marginStart, 31);
        sparseIntArray.append(s.Constraint_android_layout_marginEnd, 8);
        sparseIntArray.append(s.Constraint_android_layout_marginTop, 34);
        sparseIntArray.append(s.Constraint_android_layout_marginBottom, 2);
        sparseIntArray.append(s.Constraint_android_layout_width, 23);
        sparseIntArray.append(s.Constraint_android_layout_height, 21);
        sparseIntArray.append(s.Constraint_layout_constraintWidth, 95);
        sparseIntArray.append(s.Constraint_layout_constraintHeight, 96);
        sparseIntArray.append(s.Constraint_android_visibility, 22);
        sparseIntArray.append(s.Constraint_android_alpha, 43);
        sparseIntArray.append(s.Constraint_android_elevation, 44);
        sparseIntArray.append(s.Constraint_android_rotationX, 45);
        sparseIntArray.append(s.Constraint_android_rotationY, 46);
        sparseIntArray.append(s.Constraint_android_rotation, 60);
        sparseIntArray.append(s.Constraint_android_scaleX, 47);
        sparseIntArray.append(s.Constraint_android_scaleY, 48);
        sparseIntArray.append(s.Constraint_android_transformPivotX, 49);
        sparseIntArray.append(s.Constraint_android_transformPivotY, 50);
        sparseIntArray.append(s.Constraint_android_translationX, 51);
        sparseIntArray.append(s.Constraint_android_translationY, 52);
        sparseIntArray.append(s.Constraint_android_translationZ, 53);
        sparseIntArray.append(s.Constraint_layout_constraintWidth_default, 54);
        sparseIntArray.append(s.Constraint_layout_constraintHeight_default, 55);
        sparseIntArray.append(s.Constraint_layout_constraintWidth_max, 56);
        sparseIntArray.append(s.Constraint_layout_constraintHeight_max, 57);
        sparseIntArray.append(s.Constraint_layout_constraintWidth_min, 58);
        sparseIntArray.append(s.Constraint_layout_constraintHeight_min, 59);
        sparseIntArray.append(s.Constraint_layout_constraintCircle, 61);
        sparseIntArray.append(s.Constraint_layout_constraintCircleRadius, 62);
        sparseIntArray.append(s.Constraint_layout_constraintCircleAngle, 63);
        sparseIntArray.append(s.Constraint_animateRelativeTo, 64);
        sparseIntArray.append(s.Constraint_transitionEasing, 65);
        sparseIntArray.append(s.Constraint_drawPath, 66);
        sparseIntArray.append(s.Constraint_transitionPathRotate, 67);
        sparseIntArray.append(s.Constraint_motionStagger, 79);
        sparseIntArray.append(s.Constraint_android_id, 38);
        sparseIntArray.append(s.Constraint_motionProgress, 68);
        sparseIntArray.append(s.Constraint_layout_constraintWidth_percent, 69);
        sparseIntArray.append(s.Constraint_layout_constraintHeight_percent, 70);
        sparseIntArray.append(s.Constraint_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(s.Constraint_chainUseRtl, 71);
        sparseIntArray.append(s.Constraint_barrierDirection, 72);
        sparseIntArray.append(s.Constraint_barrierMargin, 73);
        sparseIntArray.append(s.Constraint_constraint_referenced_ids, 74);
        sparseIntArray.append(s.Constraint_barrierAllowsGoneWidgets, 75);
        sparseIntArray.append(s.Constraint_pathMotionArc, 76);
        sparseIntArray.append(s.Constraint_layout_constraintTag, 77);
        sparseIntArray.append(s.Constraint_visibilityMode, 78);
        sparseIntArray.append(s.Constraint_layout_constrainedWidth, 80);
        sparseIntArray.append(s.Constraint_layout_constrainedHeight, 81);
        sparseIntArray.append(s.Constraint_polarRelativeTo, 82);
        sparseIntArray.append(s.Constraint_transformPivotTarget, 83);
        sparseIntArray.append(s.Constraint_quantizeMotionSteps, 84);
        sparseIntArray.append(s.Constraint_quantizeMotionPhase, 85);
        sparseIntArray.append(s.Constraint_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(s.ConstraintOverride_layout_editor_absoluteY, 6);
        sparseIntArray2.append(s.ConstraintOverride_layout_editor_absoluteY, 7);
        sparseIntArray2.append(s.ConstraintOverride_android_orientation, 27);
        sparseIntArray2.append(s.ConstraintOverride_layout_goneMarginLeft, 13);
        sparseIntArray2.append(s.ConstraintOverride_layout_goneMarginTop, 16);
        sparseIntArray2.append(s.ConstraintOverride_layout_goneMarginRight, 14);
        sparseIntArray2.append(s.ConstraintOverride_layout_goneMarginBottom, 11);
        sparseIntArray2.append(s.ConstraintOverride_layout_goneMarginStart, 15);
        sparseIntArray2.append(s.ConstraintOverride_layout_goneMarginEnd, 12);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintVertical_weight, 40);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintVertical_bias, 37);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintLeft_creator, 87);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintTop_creator, 87);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintRight_creator, 87);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintBottom_creator, 87);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sparseIntArray2.append(s.ConstraintOverride_android_layout_marginLeft, 24);
        sparseIntArray2.append(s.ConstraintOverride_android_layout_marginRight, 28);
        sparseIntArray2.append(s.ConstraintOverride_android_layout_marginStart, 31);
        sparseIntArray2.append(s.ConstraintOverride_android_layout_marginEnd, 8);
        sparseIntArray2.append(s.ConstraintOverride_android_layout_marginTop, 34);
        sparseIntArray2.append(s.ConstraintOverride_android_layout_marginBottom, 2);
        sparseIntArray2.append(s.ConstraintOverride_android_layout_width, 23);
        sparseIntArray2.append(s.ConstraintOverride_android_layout_height, 21);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintWidth, 95);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintHeight, 96);
        sparseIntArray2.append(s.ConstraintOverride_android_visibility, 22);
        sparseIntArray2.append(s.ConstraintOverride_android_alpha, 43);
        sparseIntArray2.append(s.ConstraintOverride_android_elevation, 44);
        sparseIntArray2.append(s.ConstraintOverride_android_rotationX, 45);
        sparseIntArray2.append(s.ConstraintOverride_android_rotationY, 46);
        sparseIntArray2.append(s.ConstraintOverride_android_rotation, 60);
        sparseIntArray2.append(s.ConstraintOverride_android_scaleX, 47);
        sparseIntArray2.append(s.ConstraintOverride_android_scaleY, 48);
        sparseIntArray2.append(s.ConstraintOverride_android_transformPivotX, 49);
        sparseIntArray2.append(s.ConstraintOverride_android_transformPivotY, 50);
        sparseIntArray2.append(s.ConstraintOverride_android_translationX, 51);
        sparseIntArray2.append(s.ConstraintOverride_android_translationY, 52);
        sparseIntArray2.append(s.ConstraintOverride_android_translationZ, 53);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintWidth_default, 54);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintHeight_default, 55);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintWidth_max, 56);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintHeight_max, 57);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintWidth_min, 58);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintHeight_min, 59);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintCircleRadius, 62);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintCircleAngle, 63);
        sparseIntArray2.append(s.ConstraintOverride_animateRelativeTo, 64);
        sparseIntArray2.append(s.ConstraintOverride_transitionEasing, 65);
        sparseIntArray2.append(s.ConstraintOverride_drawPath, 66);
        sparseIntArray2.append(s.ConstraintOverride_transitionPathRotate, 67);
        sparseIntArray2.append(s.ConstraintOverride_motionStagger, 79);
        sparseIntArray2.append(s.ConstraintOverride_android_id, 38);
        sparseIntArray2.append(s.ConstraintOverride_motionTarget, 98);
        sparseIntArray2.append(s.ConstraintOverride_motionProgress, 68);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintWidth_percent, 69);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintHeight_percent, 70);
        sparseIntArray2.append(s.ConstraintOverride_chainUseRtl, 71);
        sparseIntArray2.append(s.ConstraintOverride_barrierDirection, 72);
        sparseIntArray2.append(s.ConstraintOverride_barrierMargin, 73);
        sparseIntArray2.append(s.ConstraintOverride_constraint_referenced_ids, 74);
        sparseIntArray2.append(s.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sparseIntArray2.append(s.ConstraintOverride_pathMotionArc, 76);
        sparseIntArray2.append(s.ConstraintOverride_layout_constraintTag, 77);
        sparseIntArray2.append(s.ConstraintOverride_visibilityMode, 78);
        sparseIntArray2.append(s.ConstraintOverride_layout_constrainedWidth, 80);
        sparseIntArray2.append(s.ConstraintOverride_layout_constrainedHeight, 81);
        sparseIntArray2.append(s.ConstraintOverride_polarRelativeTo, 82);
        sparseIntArray2.append(s.ConstraintOverride_transformPivotTarget, 83);
        sparseIntArray2.append(s.ConstraintOverride_quantizeMotionSteps, 84);
        sparseIntArray2.append(s.ConstraintOverride_quantizeMotionPhase, 85);
        sparseIntArray2.append(s.ConstraintOverride_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(s.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static int[] c(a aVar, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = aVar.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i10 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = r.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && aVar.isInEditMode() && (aVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) aVar.getParent();
                if (l4.a.v(strTrim)) {
                    HashMap map = constraintLayout.G;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.G.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i10] = iIntValue;
            i++;
            i10++;
        }
        return i10 != strArrSplit.length ? Arrays.copyOf(iArr, i10) : iArr;
    }

    public static j d(Context context, AttributeSet attributeSet, boolean z2) {
        int i;
        int i10;
        j jVar = new j();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z2 ? s.ConstraintOverride : s.Constraint);
        m mVar = jVar.f78b;
        n nVar = jVar.f81e;
        l lVar = jVar.f79c;
        k kVar = jVar.f80d;
        int[] iArr = f145d;
        String[] strArr = w.a.f13503a;
        SparseIntArray sparseIntArray = f146e;
        if (z2) {
            i iVar = new i();
            iVar.f67a = new int[10];
            iVar.f68b = new int[10];
            iVar.f69c = 0;
            iVar.f70d = new int[10];
            iVar.f71e = new float[10];
            iVar.f = 0;
            iVar.f72g = new int[5];
            iVar.f73h = new String[5];
            iVar.i = 0;
            iVar.f74j = new int[4];
            iVar.f75k = new boolean[4];
            iVar.f76l = 0;
            lVar.getClass();
            kVar.getClass();
            nVar.getClass();
            int i11 = 0;
            for (int indexCount = typedArrayObtainStyledAttributes.getIndexCount(); i11 < indexCount; indexCount = i10) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                int i12 = i11;
                switch (f.get(index)) {
                    case 2:
                        i10 = indexCount;
                        iVar.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.I));
                        continue;
                        i11 = i12 + 1;
                        break;
                    case 3:
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i10 = indexCount;
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        i10 = indexCount;
                        iVar.d(typedArrayObtainStyledAttributes.getString(index), 5);
                        continue;
                        i11 = i12 + 1;
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        i10 = indexCount;
                        iVar.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, kVar.C));
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        i10 = indexCount;
                        iVar.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, kVar.D));
                        break;
                    case 8:
                        i10 = indexCount;
                        iVar.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.J));
                        break;
                    case 11:
                        i10 = indexCount;
                        iVar.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.P));
                        break;
                    case 12:
                        i10 = indexCount;
                        iVar.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.Q));
                        break;
                    case 13:
                        i10 = indexCount;
                        iVar.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.M));
                        break;
                    case 14:
                        i10 = indexCount;
                        iVar.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.O));
                        break;
                    case 15:
                        i10 = indexCount;
                        iVar.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.R));
                        break;
                    case 16:
                        i10 = indexCount;
                        iVar.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.N));
                        break;
                    case 17:
                        i10 = indexCount;
                        iVar.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, kVar.f89d));
                        break;
                    case 18:
                        i10 = indexCount;
                        iVar.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, kVar.f91e));
                        break;
                    case 19:
                        i10 = indexCount;
                        iVar.a(19, typedArrayObtainStyledAttributes.getFloat(index, kVar.f));
                        break;
                    case 20:
                        i10 = indexCount;
                        iVar.a(20, typedArrayObtainStyledAttributes.getFloat(index, kVar.f117w));
                        break;
                    case 21:
                        i10 = indexCount;
                        iVar.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, kVar.f87c));
                        break;
                    case 22:
                        i10 = indexCount;
                        iVar.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, mVar.f129a)]);
                        break;
                    case 23:
                        i10 = indexCount;
                        iVar.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, kVar.f85b));
                        break;
                    case 24:
                        i10 = indexCount;
                        iVar.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.F));
                        break;
                    case 27:
                        i10 = indexCount;
                        iVar.b(27, typedArrayObtainStyledAttributes.getInt(index, kVar.E));
                        break;
                    case 28:
                        i10 = indexCount;
                        iVar.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.G));
                        break;
                    case 31:
                        i10 = indexCount;
                        iVar.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.K));
                        break;
                    case 34:
                        i10 = indexCount;
                        iVar.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.H));
                        break;
                    case 37:
                        i10 = indexCount;
                        iVar.a(37, typedArrayObtainStyledAttributes.getFloat(index, kVar.f118x));
                        break;
                    case 38:
                        i10 = indexCount;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, jVar.f77a);
                        jVar.f77a = resourceId;
                        iVar.b(38, resourceId);
                        break;
                    case 39:
                        i10 = indexCount;
                        iVar.a(39, typedArrayObtainStyledAttributes.getFloat(index, kVar.U));
                        break;
                    case 40:
                        i10 = indexCount;
                        iVar.a(40, typedArrayObtainStyledAttributes.getFloat(index, kVar.T));
                        break;
                    case 41:
                        i10 = indexCount;
                        iVar.b(41, typedArrayObtainStyledAttributes.getInt(index, kVar.V));
                        break;
                    case 42:
                        i10 = indexCount;
                        iVar.b(42, typedArrayObtainStyledAttributes.getInt(index, kVar.W));
                        break;
                    case 43:
                        i10 = indexCount;
                        iVar.a(43, typedArrayObtainStyledAttributes.getFloat(index, mVar.f131c));
                        break;
                    case 44:
                        i10 = indexCount;
                        iVar.c(44, true);
                        iVar.a(44, typedArrayObtainStyledAttributes.getDimension(index, nVar.f144m));
                        break;
                    case 45:
                        i10 = indexCount;
                        iVar.a(45, typedArrayObtainStyledAttributes.getFloat(index, nVar.f135b));
                        break;
                    case 46:
                        i10 = indexCount;
                        iVar.a(46, typedArrayObtainStyledAttributes.getFloat(index, nVar.f136c));
                        break;
                    case 47:
                        i10 = indexCount;
                        iVar.a(47, typedArrayObtainStyledAttributes.getFloat(index, nVar.f137d));
                        break;
                    case 48:
                        i10 = indexCount;
                        iVar.a(48, typedArrayObtainStyledAttributes.getFloat(index, nVar.f138e));
                        break;
                    case 49:
                        i10 = indexCount;
                        iVar.a(49, typedArrayObtainStyledAttributes.getDimension(index, nVar.f));
                        break;
                    case 50:
                        i10 = indexCount;
                        iVar.a(50, typedArrayObtainStyledAttributes.getDimension(index, nVar.f139g));
                        break;
                    case 51:
                        i10 = indexCount;
                        iVar.a(51, typedArrayObtainStyledAttributes.getDimension(index, nVar.i));
                        break;
                    case 52:
                        i10 = indexCount;
                        iVar.a(52, typedArrayObtainStyledAttributes.getDimension(index, nVar.f141j));
                        break;
                    case 53:
                        i10 = indexCount;
                        iVar.a(53, typedArrayObtainStyledAttributes.getDimension(index, nVar.f142k));
                        break;
                    case 54:
                        i10 = indexCount;
                        iVar.b(54, typedArrayObtainStyledAttributes.getInt(index, kVar.X));
                        break;
                    case 55:
                        i10 = indexCount;
                        iVar.b(55, typedArrayObtainStyledAttributes.getInt(index, kVar.Y));
                        break;
                    case 56:
                        i10 = indexCount;
                        iVar.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.Z));
                        break;
                    case 57:
                        i10 = indexCount;
                        iVar.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.f84a0));
                        break;
                    case 58:
                        i10 = indexCount;
                        iVar.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.f86b0));
                        break;
                    case 59:
                        i10 = indexCount;
                        iVar.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.f88c0));
                        break;
                    case 60:
                        i10 = indexCount;
                        iVar.a(60, typedArrayObtainStyledAttributes.getFloat(index, nVar.f134a));
                        break;
                    case 62:
                        i10 = indexCount;
                        iVar.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.A));
                        break;
                    case 63:
                        i10 = indexCount;
                        iVar.a(63, typedArrayObtainStyledAttributes.getFloat(index, kVar.B));
                        break;
                    case 64:
                        i10 = indexCount;
                        iVar.b(64, f(typedArrayObtainStyledAttributes, index, lVar.f122a));
                        break;
                    case 65:
                        i10 = indexCount;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            iVar.d(typedArrayObtainStyledAttributes.getString(index), 65);
                        } else {
                            iVar.d(strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)], 65);
                        }
                        break;
                    case 66:
                        i10 = indexCount;
                        iVar.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i10 = indexCount;
                        iVar.a(67, typedArrayObtainStyledAttributes.getFloat(index, lVar.f126e));
                        break;
                    case 68:
                        i10 = indexCount;
                        iVar.a(68, typedArrayObtainStyledAttributes.getFloat(index, mVar.f132d));
                        break;
                    case 69:
                        i10 = indexCount;
                        iVar.a(69, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        i10 = indexCount;
                        iVar.a(70, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        i10 = indexCount;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i10 = indexCount;
                        iVar.b(72, typedArrayObtainStyledAttributes.getInt(index, kVar.f93f0));
                        break;
                    case 73:
                        i10 = indexCount;
                        iVar.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.f95g0));
                        break;
                    case 74:
                        i10 = indexCount;
                        iVar.d(typedArrayObtainStyledAttributes.getString(index), 74);
                        break;
                    case 75:
                        i10 = indexCount;
                        iVar.c(75, typedArrayObtainStyledAttributes.getBoolean(index, kVar.f107n0));
                        break;
                    case 76:
                        i10 = indexCount;
                        iVar.b(76, typedArrayObtainStyledAttributes.getInt(index, lVar.f124c));
                        break;
                    case 77:
                        i10 = indexCount;
                        iVar.d(typedArrayObtainStyledAttributes.getString(index), 77);
                        break;
                    case 78:
                        i10 = indexCount;
                        iVar.b(78, typedArrayObtainStyledAttributes.getInt(index, mVar.f130b));
                        break;
                    case 79:
                        i10 = indexCount;
                        iVar.a(79, typedArrayObtainStyledAttributes.getFloat(index, lVar.f125d));
                        break;
                    case 80:
                        i10 = indexCount;
                        iVar.c(80, typedArrayObtainStyledAttributes.getBoolean(index, kVar.l0));
                        break;
                    case 81:
                        i10 = indexCount;
                        iVar.c(81, typedArrayObtainStyledAttributes.getBoolean(index, kVar.f105m0));
                        break;
                    case 82:
                        i10 = indexCount;
                        iVar.b(82, typedArrayObtainStyledAttributes.getInteger(index, lVar.f123b));
                        break;
                    case 83:
                        i10 = indexCount;
                        iVar.b(83, f(typedArrayObtainStyledAttributes, index, nVar.f140h));
                        break;
                    case 84:
                        i10 = indexCount;
                        iVar.b(84, typedArrayObtainStyledAttributes.getInteger(index, lVar.f127g));
                        break;
                    case 85:
                        i10 = indexCount;
                        iVar.a(85, typedArrayObtainStyledAttributes.getFloat(index, lVar.f));
                        break;
                    case 86:
                        i10 = indexCount;
                        int i13 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i13 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            lVar.i = resourceId2;
                            iVar.b(89, resourceId2);
                            if (lVar.i != -1) {
                                iVar.b(88, -2);
                            }
                        } else if (i13 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            lVar.f128h = string;
                            iVar.d(string, 90);
                            if (lVar.f128h.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                lVar.i = resourceId3;
                                iVar.b(89, resourceId3);
                                iVar.b(88, -2);
                            } else {
                                iVar.b(88, -1);
                            }
                        } else {
                            iVar.b(88, typedArrayObtainStyledAttributes.getInteger(index, lVar.i));
                        }
                        break;
                    case 87:
                        i10 = indexCount;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i10 = indexCount;
                        iVar.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.L));
                        break;
                    case 94:
                        i10 = indexCount;
                        iVar.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, kVar.S));
                        break;
                    case 95:
                        i10 = indexCount;
                        g(iVar, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i10 = indexCount;
                        g(iVar, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i10 = indexCount;
                        iVar.b(97, typedArrayObtainStyledAttributes.getInt(index, kVar.f109o0));
                        break;
                    case 98:
                        i10 = indexCount;
                        int i14 = z.a.M;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            jVar.f77a = typedArrayObtainStyledAttributes.getResourceId(index, jVar.f77a);
                        }
                        break;
                    case 99:
                        i10 = indexCount;
                        iVar.c(99, typedArrayObtainStyledAttributes.getBoolean(index, kVar.f94g));
                        break;
                }
                i11 = i12 + 1;
            }
        } else {
            int i15 = 0;
            for (int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount(); i15 < indexCount2; indexCount2 = i) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i15);
                if (index2 != s.Constraint_android_id && s.Constraint_android_layout_marginStart != index2 && s.Constraint_android_layout_marginEnd != index2) {
                    lVar.getClass();
                    kVar.getClass();
                    nVar.getClass();
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i = indexCount2;
                        kVar.f110p = f(typedArrayObtainStyledAttributes, index2, kVar.f110p);
                        continue;
                        i15++;
                        break;
                    case 2:
                        i = indexCount2;
                        kVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.I);
                        continue;
                        i15++;
                        break;
                    case 3:
                        i = indexCount2;
                        kVar.f108o = f(typedArrayObtainStyledAttributes, index2, kVar.f108o);
                        continue;
                        i15++;
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        i = indexCount2;
                        kVar.f106n = f(typedArrayObtainStyledAttributes, index2, kVar.f106n);
                        continue;
                        i15++;
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        i = indexCount2;
                        kVar.f119y = typedArrayObtainStyledAttributes.getString(index2);
                        continue;
                        i15++;
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        i = indexCount2;
                        kVar.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, kVar.C);
                        continue;
                        i15++;
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        i = indexCount2;
                        kVar.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, kVar.D);
                        continue;
                        i15++;
                        break;
                    case 8:
                        i = indexCount2;
                        kVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.J);
                        continue;
                        i15++;
                        break;
                    case 9:
                        i = indexCount2;
                        kVar.f116v = f(typedArrayObtainStyledAttributes, index2, kVar.f116v);
                        continue;
                        i15++;
                        break;
                    case 10:
                        i = indexCount2;
                        kVar.f115u = f(typedArrayObtainStyledAttributes, index2, kVar.f115u);
                        continue;
                        i15++;
                        break;
                    case 11:
                        i = indexCount2;
                        kVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.P);
                        continue;
                        i15++;
                        break;
                    case 12:
                        i = indexCount2;
                        kVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.Q);
                        continue;
                        i15++;
                        break;
                    case 13:
                        i = indexCount2;
                        kVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.M);
                        continue;
                        i15++;
                        break;
                    case 14:
                        i = indexCount2;
                        kVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.O);
                        continue;
                        i15++;
                        break;
                    case 15:
                        i = indexCount2;
                        kVar.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.R);
                        continue;
                        i15++;
                        break;
                    case 16:
                        i = indexCount2;
                        kVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.N);
                        continue;
                        i15++;
                        break;
                    case 17:
                        i = indexCount2;
                        kVar.f89d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, kVar.f89d);
                        continue;
                        i15++;
                        break;
                    case 18:
                        i = indexCount2;
                        kVar.f91e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, kVar.f91e);
                        continue;
                        i15++;
                        break;
                    case 19:
                        i = indexCount2;
                        kVar.f = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f);
                        continue;
                        i15++;
                        break;
                    case 20:
                        i = indexCount2;
                        kVar.f117w = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f117w);
                        continue;
                        i15++;
                        break;
                    case 21:
                        i = indexCount2;
                        kVar.f87c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, kVar.f87c);
                        continue;
                        i15++;
                        break;
                    case 22:
                        i = indexCount2;
                        int i16 = typedArrayObtainStyledAttributes.getInt(index2, mVar.f129a);
                        mVar.f129a = i16;
                        mVar.f129a = iArr[i16];
                        continue;
                        i15++;
                        break;
                    case 23:
                        i = indexCount2;
                        kVar.f85b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, kVar.f85b);
                        continue;
                        i15++;
                        break;
                    case 24:
                        i = indexCount2;
                        kVar.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.F);
                        continue;
                        i15++;
                        break;
                    case 25:
                        i = indexCount2;
                        kVar.f96h = f(typedArrayObtainStyledAttributes, index2, kVar.f96h);
                        continue;
                        i15++;
                        break;
                    case 26:
                        i = indexCount2;
                        kVar.i = f(typedArrayObtainStyledAttributes, index2, kVar.i);
                        continue;
                        i15++;
                        break;
                    case 27:
                        i = indexCount2;
                        kVar.E = typedArrayObtainStyledAttributes.getInt(index2, kVar.E);
                        continue;
                        i15++;
                        break;
                    case 28:
                        i = indexCount2;
                        kVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.G);
                        continue;
                        i15++;
                        break;
                    case 29:
                        i = indexCount2;
                        kVar.f99j = f(typedArrayObtainStyledAttributes, index2, kVar.f99j);
                        continue;
                        i15++;
                        break;
                    case 30:
                        i = indexCount2;
                        kVar.f101k = f(typedArrayObtainStyledAttributes, index2, kVar.f101k);
                        continue;
                        i15++;
                        break;
                    case 31:
                        i = indexCount2;
                        kVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.K);
                        continue;
                        i15++;
                        break;
                    case 32:
                        i = indexCount2;
                        kVar.f113s = f(typedArrayObtainStyledAttributes, index2, kVar.f113s);
                        continue;
                        i15++;
                        break;
                    case 33:
                        i = indexCount2;
                        kVar.f114t = f(typedArrayObtainStyledAttributes, index2, kVar.f114t);
                        continue;
                        i15++;
                        break;
                    case 34:
                        i = indexCount2;
                        kVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.H);
                        continue;
                        i15++;
                        break;
                    case 35:
                        i = indexCount2;
                        kVar.f104m = f(typedArrayObtainStyledAttributes, index2, kVar.f104m);
                        continue;
                        i15++;
                        break;
                    case 36:
                        i = indexCount2;
                        kVar.f103l = f(typedArrayObtainStyledAttributes, index2, kVar.f103l);
                        continue;
                        i15++;
                        break;
                    case 37:
                        i = indexCount2;
                        kVar.f118x = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f118x);
                        continue;
                        i15++;
                        break;
                    case 38:
                        i = indexCount2;
                        jVar.f77a = typedArrayObtainStyledAttributes.getResourceId(index2, jVar.f77a);
                        continue;
                        i15++;
                        break;
                    case 39:
                        i = indexCount2;
                        kVar.U = typedArrayObtainStyledAttributes.getFloat(index2, kVar.U);
                        continue;
                        i15++;
                        break;
                    case 40:
                        i = indexCount2;
                        kVar.T = typedArrayObtainStyledAttributes.getFloat(index2, kVar.T);
                        continue;
                        i15++;
                        break;
                    case 41:
                        i = indexCount2;
                        kVar.V = typedArrayObtainStyledAttributes.getInt(index2, kVar.V);
                        continue;
                        i15++;
                        break;
                    case 42:
                        i = indexCount2;
                        kVar.W = typedArrayObtainStyledAttributes.getInt(index2, kVar.W);
                        continue;
                        i15++;
                        break;
                    case 43:
                        i = indexCount2;
                        mVar.f131c = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f131c);
                        continue;
                        i15++;
                        break;
                    case 44:
                        i = indexCount2;
                        nVar.f143l = true;
                        nVar.f144m = typedArrayObtainStyledAttributes.getDimension(index2, nVar.f144m);
                        continue;
                        i15++;
                        break;
                    case 45:
                        i = indexCount2;
                        nVar.f135b = typedArrayObtainStyledAttributes.getFloat(index2, nVar.f135b);
                        continue;
                        i15++;
                        break;
                    case 46:
                        i = indexCount2;
                        nVar.f136c = typedArrayObtainStyledAttributes.getFloat(index2, nVar.f136c);
                        continue;
                        i15++;
                        break;
                    case 47:
                        i = indexCount2;
                        nVar.f137d = typedArrayObtainStyledAttributes.getFloat(index2, nVar.f137d);
                        continue;
                        i15++;
                        break;
                    case 48:
                        i = indexCount2;
                        nVar.f138e = typedArrayObtainStyledAttributes.getFloat(index2, nVar.f138e);
                        continue;
                        i15++;
                        break;
                    case 49:
                        i = indexCount2;
                        nVar.f = typedArrayObtainStyledAttributes.getDimension(index2, nVar.f);
                        continue;
                        i15++;
                        break;
                    case 50:
                        i = indexCount2;
                        nVar.f139g = typedArrayObtainStyledAttributes.getDimension(index2, nVar.f139g);
                        continue;
                        i15++;
                        break;
                    case 51:
                        i = indexCount2;
                        nVar.i = typedArrayObtainStyledAttributes.getDimension(index2, nVar.i);
                        continue;
                        i15++;
                        break;
                    case 52:
                        i = indexCount2;
                        nVar.f141j = typedArrayObtainStyledAttributes.getDimension(index2, nVar.f141j);
                        continue;
                        i15++;
                        break;
                    case 53:
                        i = indexCount2;
                        nVar.f142k = typedArrayObtainStyledAttributes.getDimension(index2, nVar.f142k);
                        continue;
                        i15++;
                        break;
                    case 54:
                        i = indexCount2;
                        kVar.X = typedArrayObtainStyledAttributes.getInt(index2, kVar.X);
                        continue;
                        i15++;
                        break;
                    case 55:
                        i = indexCount2;
                        kVar.Y = typedArrayObtainStyledAttributes.getInt(index2, kVar.Y);
                        continue;
                        i15++;
                        break;
                    case 56:
                        i = indexCount2;
                        kVar.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.Z);
                        continue;
                        i15++;
                        break;
                    case 57:
                        i = indexCount2;
                        kVar.f84a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.f84a0);
                        continue;
                        i15++;
                        break;
                    case 58:
                        i = indexCount2;
                        kVar.f86b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.f86b0);
                        continue;
                        i15++;
                        break;
                    case 59:
                        i = indexCount2;
                        kVar.f88c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.f88c0);
                        continue;
                        i15++;
                        break;
                    case 60:
                        i = indexCount2;
                        nVar.f134a = typedArrayObtainStyledAttributes.getFloat(index2, nVar.f134a);
                        continue;
                        i15++;
                        break;
                    case 61:
                        i = indexCount2;
                        kVar.f120z = f(typedArrayObtainStyledAttributes, index2, kVar.f120z);
                        continue;
                        i15++;
                        break;
                    case 62:
                        i = indexCount2;
                        kVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.A);
                        continue;
                        i15++;
                        break;
                    case 63:
                        i = indexCount2;
                        kVar.B = typedArrayObtainStyledAttributes.getFloat(index2, kVar.B);
                        continue;
                        i15++;
                        break;
                    case 64:
                        i = indexCount2;
                        lVar.f122a = f(typedArrayObtainStyledAttributes, index2, lVar.f122a);
                        continue;
                        i15++;
                        break;
                    case 65:
                        i = indexCount2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index2);
                            lVar.getClass();
                        } else {
                            String str = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            lVar.getClass();
                            i15++;
                        }
                        break;
                    case 66:
                        i = indexCount2;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        lVar.getClass();
                        continue;
                        i15++;
                        break;
                    case 67:
                        i = indexCount2;
                        lVar.f126e = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f126e);
                        break;
                    case 68:
                        i = indexCount2;
                        mVar.f132d = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f132d);
                        break;
                    case 69:
                        i = indexCount2;
                        kVar.f90d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i = indexCount2;
                        kVar.f92e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i = indexCount2;
                        kVar.f93f0 = typedArrayObtainStyledAttributes.getInt(index2, kVar.f93f0);
                        break;
                    case 73:
                        i = indexCount2;
                        kVar.f95g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.f95g0);
                        break;
                    case 74:
                        i = indexCount2;
                        kVar.f100j0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i = indexCount2;
                        kVar.f107n0 = typedArrayObtainStyledAttributes.getBoolean(index2, kVar.f107n0);
                        break;
                    case 76:
                        i = indexCount2;
                        lVar.f124c = typedArrayObtainStyledAttributes.getInt(index2, lVar.f124c);
                        break;
                    case 77:
                        i = indexCount2;
                        kVar.f102k0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i = indexCount2;
                        mVar.f130b = typedArrayObtainStyledAttributes.getInt(index2, mVar.f130b);
                        break;
                    case 79:
                        i = indexCount2;
                        lVar.f125d = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f125d);
                        break;
                    case 80:
                        i = indexCount2;
                        kVar.l0 = typedArrayObtainStyledAttributes.getBoolean(index2, kVar.l0);
                        break;
                    case 81:
                        i = indexCount2;
                        kVar.f105m0 = typedArrayObtainStyledAttributes.getBoolean(index2, kVar.f105m0);
                        break;
                    case 82:
                        i = indexCount2;
                        lVar.f123b = typedArrayObtainStyledAttributes.getInteger(index2, lVar.f123b);
                        break;
                    case 83:
                        i = indexCount2;
                        nVar.f140h = f(typedArrayObtainStyledAttributes, index2, nVar.f140h);
                        break;
                    case 84:
                        i = indexCount2;
                        lVar.f127g = typedArrayObtainStyledAttributes.getInteger(index2, lVar.f127g);
                        break;
                    case 85:
                        i = indexCount2;
                        lVar.f = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f);
                        break;
                    case 86:
                        i = indexCount2;
                        int i17 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i17 == 1) {
                            lVar.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i17 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            lVar.f128h = string2;
                            if (string2.indexOf("/") > 0) {
                                lVar.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, lVar.i);
                        }
                        break;
                    case 87:
                        i = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb3 = new StringBuilder("Unknown attribute 0x");
                        i = indexCount2;
                        sb3.append(Integer.toHexString(index2));
                        sb3.append("   ");
                        sb3.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb3.toString());
                        break;
                    case 91:
                        i = indexCount2;
                        kVar.f111q = f(typedArrayObtainStyledAttributes, index2, kVar.f111q);
                        break;
                    case 92:
                        i = indexCount2;
                        kVar.f112r = f(typedArrayObtainStyledAttributes, index2, kVar.f112r);
                        break;
                    case 93:
                        i = indexCount2;
                        kVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.L);
                        break;
                    case 94:
                        i = indexCount2;
                        kVar.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, kVar.S);
                        break;
                    case 95:
                        i = indexCount2;
                        g(kVar, typedArrayObtainStyledAttributes, index2, 0);
                        continue;
                        i15++;
                        break;
                    case 96:
                        i = indexCount2;
                        g(kVar, typedArrayObtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i = indexCount2;
                        kVar.f109o0 = typedArrayObtainStyledAttributes.getInt(index2, kVar.f109o0);
                        break;
                }
                i15++;
            }
            if (kVar.f100j0 != null) {
                kVar.f98i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return jVar;
    }

    public static int f(TypedArray typedArray, int i, int i10) {
        int resourceId = typedArray.getResourceId(i, i10);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.o.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(e eVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f4 = Float.parseFloat(strSubstring3);
                        float f10 = Float.parseFloat(strSubstring4);
                        if (f4 > 0.0f && f10 > 0.0f) {
                            if (i == 1) {
                                Math.abs(f10 / f4);
                            } else {
                                Math.abs(f4 / f10);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        eVar.G = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ConstraintLayout constraintLayout) {
        boolean z2;
        HashSet hashSet;
        int i;
        HashMap map;
        String resourceEntryName;
        o oVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = oVar.f149c;
        HashSet<Integer> hashSet2 = new HashSet(map2.keySet());
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!map2.containsKey(Integer.valueOf(id2))) {
                StringBuilder sb2 = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb2.append(resourceEntryName);
                Log.w("ConstraintSet", sb2.toString());
            } else {
                if (oVar.f148b && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (map2.containsKey(Integer.valueOf(id2))) {
                        hashSet2.remove(Integer.valueOf(id2));
                        j jVar = (j) map2.get(Integer.valueOf(id2));
                        if (jVar != null) {
                            m mVar = jVar.f78b;
                            k kVar = jVar.f80d;
                            n nVar = jVar.f81e;
                            if (childAt instanceof a) {
                                kVar.f97h0 = 1;
                                a aVar = (a) childAt;
                                aVar.setId(id2);
                                aVar.setType(kVar.f93f0);
                                aVar.setMargin(kVar.f95g0);
                                aVar.setAllowsGoneWidget(kVar.f107n0);
                                int[] iArr = kVar.f98i0;
                                if (iArr != null) {
                                    aVar.setReferencedIds(iArr);
                                } else {
                                    String str = kVar.f100j0;
                                    if (str != null) {
                                        int[] iArrC = c(aVar, str);
                                        kVar.f98i0 = iArrC;
                                        aVar.setReferencedIds(iArrC);
                                    }
                                }
                            }
                            e eVar = (e) childAt.getLayoutParams();
                            eVar.a();
                            jVar.a(eVar);
                            HashMap map3 = jVar.f;
                            Class<?> cls = childAt.getClass();
                            for (String str2 : map3.keySet()) {
                                b bVar = (b) map3.get(str2);
                                HashSet hashSet3 = hashSet2;
                                String strM = !bVar.f0a ? l4.a.m("set", str2) : str2;
                                int i11 = i10;
                                try {
                                    int iC = v.e.c(bVar.f1b);
                                    Class<?> cls2 = Float.TYPE;
                                    Class<?> cls3 = Integer.TYPE;
                                    switch (iC) {
                                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                            map = map3;
                                            cls.getMethod(strM, cls3).invoke(childAt, Integer.valueOf(bVar.f2c));
                                            break;
                                        case 1:
                                            map = map3;
                                            cls.getMethod(strM, cls2).invoke(childAt, Float.valueOf(bVar.f3d));
                                            break;
                                        case 2:
                                            map = map3;
                                            cls.getMethod(strM, cls3).invoke(childAt, Integer.valueOf(bVar.f5g));
                                            break;
                                        case 3:
                                            map = map3;
                                            Method method = cls.getMethod(strM, Drawable.class);
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(bVar.f5g);
                                            method.invoke(childAt, colorDrawable);
                                            break;
                                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                            map = map3;
                                            cls.getMethod(strM, CharSequence.class).invoke(childAt, bVar.f4e);
                                            break;
                                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                            map = map3;
                                            cls.getMethod(strM, Boolean.TYPE).invoke(childAt, Boolean.valueOf(bVar.f));
                                            break;
                                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                            map = map3;
                                            cls.getMethod(strM, cls2).invoke(childAt, Float.valueOf(bVar.f3d));
                                            break;
                                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                            map = map3;
                                            try {
                                                cls.getMethod(strM, cls3).invoke(childAt, Integer.valueOf(bVar.f2c));
                                            } catch (IllegalAccessException e10) {
                                                e = e10;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                e.printStackTrace();
                                            } catch (NoSuchMethodException e11) {
                                                e = e11;
                                                Log.e("TransitionLayout", e.getMessage());
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + strM);
                                            } catch (InvocationTargetException e12) {
                                                e = e12;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                e.printStackTrace();
                                            }
                                            break;
                                        default:
                                            map = map3;
                                            break;
                                    }
                                } catch (IllegalAccessException e13) {
                                    e = e13;
                                    map = map3;
                                } catch (NoSuchMethodException e14) {
                                    e = e14;
                                    map = map3;
                                } catch (InvocationTargetException e15) {
                                    e = e15;
                                    map = map3;
                                }
                                hashSet2 = hashSet3;
                                i10 = i11;
                                map3 = map;
                            }
                            hashSet = hashSet2;
                            i = i10;
                            childAt.setLayoutParams(eVar);
                            if (mVar.f130b == 0) {
                                childAt.setVisibility(mVar.f129a);
                            }
                            childAt.setAlpha(mVar.f131c);
                            childAt.setRotation(nVar.f134a);
                            childAt.setRotationX(nVar.f135b);
                            childAt.setRotationY(nVar.f136c);
                            childAt.setScaleX(nVar.f137d);
                            childAt.setScaleY(nVar.f138e);
                            if (nVar.f140h != -1) {
                                if (((View) childAt.getParent()).findViewById(nVar.f140h) != null) {
                                    float bottom = (r0.getBottom() + r0.getTop()) / 2.0f;
                                    float right = (r0.getRight() + r0.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(nVar.f)) {
                                    childAt.setPivotX(nVar.f);
                                }
                                if (!Float.isNaN(nVar.f139g)) {
                                    childAt.setPivotY(nVar.f139g);
                                }
                            }
                            childAt.setTranslationX(nVar.i);
                            childAt.setTranslationY(nVar.f141j);
                            childAt.setTranslationZ(nVar.f142k);
                            if (nVar.f143l) {
                                childAt.setElevation(nVar.f144m);
                            }
                        }
                    } else {
                        hashSet = hashSet2;
                        i = i10;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
                i10 = i + 1;
                oVar = this;
                hashSet2 = hashSet;
            }
            hashSet = hashSet2;
            i = i10;
            i10 = i + 1;
            oVar = this;
            hashSet2 = hashSet;
        }
        boolean z10 = false;
        for (Integer num : hashSet2) {
            j jVar2 = (j) map2.get(num);
            if (jVar2 != null) {
                k kVar2 = jVar2.f80d;
                if (kVar2.f97h0 == 1) {
                    Context context = constraintLayout.getContext();
                    a aVar2 = new a(context);
                    aVar2.f6u = new int[32];
                    aVar2.A = new HashMap();
                    aVar2.f8w = context;
                    x.a aVar3 = new x.a();
                    z2 = z10 ? 1 : 0;
                    aVar3.f14095s0 = z2 ? 1 : 0;
                    aVar3.f14096t0 = true;
                    aVar3.f14097u0 = z2 ? 1 : 0;
                    aVar3.f14098v0 = z2;
                    aVar2.D = aVar3;
                    aVar2.f9x = aVar3;
                    aVar2.i();
                    aVar2.setVisibility(8);
                    aVar2.setId(num.intValue());
                    int[] iArr2 = kVar2.f98i0;
                    if (iArr2 != null) {
                        aVar2.setReferencedIds(iArr2);
                    } else {
                        String str3 = kVar2.f100j0;
                        if (str3 != null) {
                            int[] iArrC2 = c(aVar2, str3);
                            kVar2.f98i0 = iArrC2;
                            aVar2.setReferencedIds(iArrC2);
                        }
                    }
                    aVar2.setType(kVar2.f93f0);
                    aVar2.setMargin(kVar2.f95g0);
                    e eVarG = ConstraintLayout.g();
                    aVar2.i();
                    jVar2.a(eVarG);
                    constraintLayout.addView(aVar2, eVarG);
                } else {
                    z2 = z10 ? 1 : 0;
                }
                if (kVar2.f83a) {
                    View qVar = new q(constraintLayout.getContext());
                    qVar.setId(num.intValue());
                    e eVarG2 = ConstraintLayout.g();
                    jVar2.a(eVarG2);
                    constraintLayout.addView(qVar, eVarG2);
                }
                z10 = z2;
            }
        }
        for (int i12 = (z10 ? 1 : 0) == true ? 1 : 0; i12 < childCount; i12++) {
            View childAt2 = constraintLayout.getChildAt(i12);
            if (childAt2 instanceof c) {
                ((c) childAt2).e(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i;
        HashMap map;
        HashMap map2;
        o oVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map3 = oVar.f149c;
        map3.clear();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = constraintLayout.getChildAt(i10);
            e eVar = (e) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (oVar.f148b && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map3.containsKey(Integer.valueOf(id2))) {
                map3.put(Integer.valueOf(id2), new j());
            }
            j jVar = (j) map3.get(Integer.valueOf(id2));
            if (jVar == null) {
                i = childCount;
                map = map3;
            } else {
                m mVar = jVar.f78b;
                k kVar = jVar.f80d;
                n nVar = jVar.f81e;
                HashMap map4 = new HashMap();
                Class<?> cls = childAt.getClass();
                HashMap map5 = oVar.f147a;
                for (String str : map5.keySet()) {
                    b bVar = (b) map5.get(str);
                    int i11 = childCount;
                    try {
                        if (str.equals("BackgroundColor")) {
                            map2 = map3;
                            try {
                                map4.put(str, new b(bVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } catch (IllegalAccessException e10) {
                                e = e10;
                                e.printStackTrace();
                            } catch (NoSuchMethodException e11) {
                                e = e11;
                                e.printStackTrace();
                            } catch (InvocationTargetException e12) {
                                e = e12;
                                e.printStackTrace();
                            }
                        } else {
                            map2 = map3;
                            map4.put(str, new b(bVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e13) {
                        e = e13;
                        map2 = map3;
                    } catch (NoSuchMethodException e14) {
                        e = e14;
                        map2 = map3;
                    } catch (InvocationTargetException e15) {
                        e = e15;
                        map2 = map3;
                    }
                    childCount = i11;
                    map3 = map2;
                }
                i = childCount;
                map = map3;
                jVar.f = map4;
                jVar.f77a = id2;
                kVar.f96h = eVar.f21e;
                kVar.i = eVar.f;
                kVar.f99j = eVar.f24g;
                kVar.f101k = eVar.f26h;
                kVar.f103l = eVar.i;
                kVar.f104m = eVar.f29j;
                kVar.f106n = eVar.f31k;
                kVar.f108o = eVar.f33l;
                kVar.f110p = eVar.f34m;
                kVar.f111q = eVar.f36n;
                kVar.f112r = eVar.f38o;
                kVar.f113s = eVar.f44s;
                kVar.f114t = eVar.f45t;
                kVar.f115u = eVar.f46u;
                kVar.f116v = eVar.f47v;
                kVar.f117w = eVar.E;
                kVar.f118x = eVar.F;
                kVar.f119y = eVar.G;
                kVar.f120z = eVar.f40p;
                kVar.A = eVar.f42q;
                kVar.B = eVar.f43r;
                kVar.C = eVar.T;
                kVar.D = eVar.U;
                kVar.E = eVar.V;
                kVar.f = eVar.f17c;
                kVar.f89d = eVar.f13a;
                kVar.f91e = eVar.f15b;
                kVar.f85b = ((ViewGroup.MarginLayoutParams) eVar).width;
                kVar.f87c = ((ViewGroup.MarginLayoutParams) eVar).height;
                kVar.F = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                kVar.G = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                kVar.H = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                kVar.I = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                kVar.L = eVar.D;
                kVar.T = eVar.I;
                kVar.U = eVar.H;
                kVar.W = eVar.K;
                kVar.V = eVar.J;
                kVar.l0 = eVar.W;
                kVar.f105m0 = eVar.X;
                kVar.X = eVar.L;
                kVar.Y = eVar.M;
                kVar.Z = eVar.P;
                kVar.f84a0 = eVar.Q;
                kVar.f86b0 = eVar.N;
                kVar.f88c0 = eVar.O;
                kVar.f90d0 = eVar.R;
                kVar.f92e0 = eVar.S;
                kVar.f102k0 = eVar.Y;
                kVar.N = eVar.f49x;
                kVar.P = eVar.f51z;
                kVar.M = eVar.f48w;
                kVar.O = eVar.f50y;
                kVar.R = eVar.A;
                kVar.Q = eVar.B;
                kVar.S = eVar.C;
                kVar.f109o0 = eVar.Z;
                kVar.J = eVar.getMarginEnd();
                kVar.K = eVar.getMarginStart();
                mVar.f129a = childAt.getVisibility();
                mVar.f131c = childAt.getAlpha();
                nVar.f134a = childAt.getRotation();
                nVar.f135b = childAt.getRotationX();
                nVar.f136c = childAt.getRotationY();
                nVar.f137d = childAt.getScaleX();
                nVar.f138e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    nVar.f = pivotX;
                    nVar.f139g = pivotY;
                }
                nVar.i = childAt.getTranslationX();
                nVar.f141j = childAt.getTranslationY();
                nVar.f142k = childAt.getTranslationZ();
                if (nVar.f143l) {
                    nVar.f144m = childAt.getElevation();
                }
                if (childAt instanceof a) {
                    a aVar = (a) childAt;
                    kVar.f107n0 = aVar.getAllowsGoneWidget();
                    kVar.f98i0 = aVar.getReferencedIds();
                    kVar.f93f0 = aVar.getType();
                    kVar.f95g0 = aVar.getMargin();
                }
            }
            i10++;
            oVar = this;
            childCount = i;
            map3 = map;
        }
    }

    public final void e(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    j jVarD = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        jVarD.f80d.f83a = true;
                    }
                    this.f149c.put(Integer.valueOf(jVarD.f77a), jVarD);
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }
}
