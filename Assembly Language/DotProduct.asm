; Indexed Addressing Dot Product
; 30 September 2019, Edward Flores, Just me

.386

.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
x DWORD 1h, 3h, 5h, 7h, 9h
y DWORD 8h, 6h, 4h, 2h, 0h
answer DWORD 0
.code
main proc
	mov ecx, LENGTHOF x		; Count down from number of items in x array
	mov esi, 0				; Sets esi to 0 starting position in array

l1:
	mov eax, [x + esi]		; Gets number from x
	mov ebx, [y + esi]		; Gets number from y
	mul ebx					; Multiplies eax and ebx
	add answer, eax			; adds product in answer
	add esi, TYPE x			; Point to ith number in both arrays
	loop l1

	invoke ExitProcess,0
main endp
end main