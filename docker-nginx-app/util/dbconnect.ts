import { PrismaClient } from '@prisma/client'
const prisma = new PrismaClient()

export async function getText() {
    prisma.$connect();
    try {
        const text = await prisma.text.findUnique({
            where: {
                id: 1,
            },
        });

        return text?.text;
    } catch (error) {
        console.error(error);
    }

    prisma.$disconnect();
}

export async function insertText() {
    prisma.$connect();
    try {
        await prisma.text.create({
            data: {
                text: "Loaded from db" 
            }
        });
    } catch(error) {
        console.error(error);
    }
    prisma.$disconnect();
}